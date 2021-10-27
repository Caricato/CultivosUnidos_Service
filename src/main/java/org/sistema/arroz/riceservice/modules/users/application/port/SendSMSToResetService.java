package org.sistema.arroz.riceservice.modules.users.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.SendSMSToResetUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.out.SendSMSToResetPort;

@UseCase
@RequiredArgsConstructor
public class SendSMSToResetService implements SendSMSToResetUseCase {
    private final GetProducerUseCase getProducerUseCase;
    private final SendSMSToResetPort sendSMSPort;

    @Override
    public void sendSMSToResetPassword(String dni) {
        var producer = getProducerUseCase.getProducer(dni);
        sendSMSPort.sendSMSToResetPassword(producer);
    }
}
