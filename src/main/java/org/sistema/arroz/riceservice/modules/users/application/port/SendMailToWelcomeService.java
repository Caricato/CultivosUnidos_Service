package org.sistema.arroz.riceservice.modules.users.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerUseCase;
import org.sistema.arroz.riceservice.modules.token.application.port.in.GenerateChangePasswordTokenUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.SendMailToWelcomeUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.out.SendMailToWelcomePort;

import javax.mail.MessagingException;

@UseCase
@RequiredArgsConstructor
public class SendMailToWelcomeService implements SendMailToWelcomeUseCase {
    private final SendMailToWelcomePort sendMailToWelcomePort;
    private final GetProducerUseCase getProducerUseCase;
    private final GenerateChangePasswordTokenUseCase generateChangePasswordTokenUseCase;

    @Override
    public void sendMailToWelcome(String dni, String url) throws MessagingException {
        var producer = getProducerUseCase.getProducer(dni);
        var token = generateChangePasswordTokenUseCase.generateChangePassword(producer.getDni(), producer.getEmail());
        sendMailToWelcomePort.sendMailToWelcome(url, token, producer);
    }
}
