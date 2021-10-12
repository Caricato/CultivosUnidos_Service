package org.sistema.arroz.riceservice.modules.users.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerUseCase;
import org.sistema.arroz.riceservice.modules.token.application.port.in.GenerateChangePasswordTokenUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.SendMailToResetUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.out.SendMailToResetPort;

import javax.mail.MessagingException;

@UseCase
@RequiredArgsConstructor
public class SendMailToResetService implements SendMailToResetUseCase {
    private final SendMailToResetPort sendMailToResetPort;
    private final GetProducerUseCase getProducerUseCase;
    private final GenerateChangePasswordTokenUseCase generateChangePasswordTokenUseCase;

    @Override
    public void sendMailToReset(String dni, String url) throws MessagingException {
        var producer = getProducerUseCase.getProducer(dni);
        var token = generateChangePasswordTokenUseCase.generateChangePassword(producer.getDni(), producer.getEmail());
        sendMailToResetPort.sendMailToReset(producer.getEmail(), url, token);
    }
}
