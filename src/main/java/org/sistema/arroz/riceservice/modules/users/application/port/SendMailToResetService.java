package org.sistema.arroz.riceservice.modules.users.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.sms.Messages;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerUseCase;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.GetSupervisorUseCase;
import org.sistema.arroz.riceservice.modules.token.application.port.in.GenerateChangePasswordTokenUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GetUserUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.SendMailToResetUseCase;
import org.sistema.arroz.riceservice.modules.notifications.application.port.in.SendSMSToResetUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.out.SendMailToResetPort;
import org.sistema.arroz.riceservice.modules.users.domain.UserRole;

import javax.mail.MessagingException;

@UseCase
@RequiredArgsConstructor
public class SendMailToResetService implements SendMailToResetUseCase {
    private final SendMailToResetPort sendMailToResetPort;
    private final GetProducerUseCase getProducerUseCase;
    private final SendSMSToResetUseCase sendSMSToResetUseCase;
    private final GetUserUseCase getUserUseCase;
    private final GetSupervisorUseCase getSupervisorUseCase;
    private final GenerateChangePasswordTokenUseCase generateChangePasswordTokenUseCase;

    @Override
    public void sendMailToReset(String dni, String url) throws MessagingException {
        var user = getUserUseCase.getUserByUsername(dni);
        if (user.getRole().equals(UserRole.PRODUCER)){
            var producer = getProducerUseCase.getProducer(dni);
            var token = generateChangePasswordTokenUseCase.generateChangePassword(producer.getDni(), producer.getEmail());
            sendMailToResetPort.sendMailToReset(producer.getEmail(), url, token);
            var message = String.format(Messages.SMS_TO_RESET, producer.getProducerName(), producer.getProducerFirstLastName());
            sendSMSToResetUseCase.sendSMSToReset(dni, message);
        }
        else{
            var supervisor = getSupervisorUseCase.getSupervisorByDNI(dni);
            var token = generateChangePasswordTokenUseCase.generateChangePassword(supervisor.getDni(), supervisor.getEmail());
            sendMailToResetPort.sendMailToReset(supervisor.getEmail(), url, token);
        }
    }
}
