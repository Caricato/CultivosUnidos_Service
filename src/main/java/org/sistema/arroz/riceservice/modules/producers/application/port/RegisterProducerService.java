package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.GetAgricultureCommunityUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToRegister;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.RegisterProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.RegisterProducerPort;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.sistema.arroz.riceservice.modules.producers.domain.RegisterProducerException;
import org.sistema.arroz.riceservice.modules.users.application.port.in.RegisterUserUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.SendMailToWelcomeUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.UserToRegister;
import org.sistema.arroz.riceservice.modules.users.application.port.out.DeleteUserPort;
import org.sistema.arroz.riceservice.modules.users.domain.UserRole;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

@UseCase
@RequiredArgsConstructor
public class RegisterProducerService implements RegisterProducerUseCase {
    private final GetAgricultureCommunityUseCase getAgricultureCommunityUseCase;
    private final RegisterProducerPort registerProducerPort;
    private final DeleteUserPort deleteUserPort;
    private final RegisterUserUseCase registerUserUseCase;
    private final SendMailToWelcomeUseCase sendMailToWelcomeUseCase;

    @Override
    public Producer registerProducer(Long communityId, ProducerToRegister producerToRegister, HttpServletRequest request) {
        var community = getAgricultureCommunityUseCase.findCommunityById(communityId);
        var user = registerUserUseCase.registerUser(UserToRegister.builder().username(producerToRegister.getDni()).role(UserRole.PRODUCER).build());
        var producer =  Producer.builder().build();
        try{
            producer = registerProducerPort.registerProducer(community, user, producerToRegister);
        }catch(Exception ex){
            deleteUserPort.deleteUser(user.getUserId());
            throw new RegisterProducerException(producerToRegister);
        }

        try{
            sendMailToWelcomeUseCase.sendMailToWelcome(producer.getDni(),request.getHeader("referer")+"restaurar");
        }catch (MessagingException e) {
            e.printStackTrace();
        }
        return producer;
    }
}
