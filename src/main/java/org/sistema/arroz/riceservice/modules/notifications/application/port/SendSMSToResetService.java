package org.sistema.arroz.riceservice.modules.notifications.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.notifications.application.port.out.SendSMSPort;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerUseCase;
import org.sistema.arroz.riceservice.modules.notifications.application.port.in.SendSMSToResetUseCase;

@UseCase
@RequiredArgsConstructor
public class SendSMSToResetService implements SendSMSToResetUseCase {
    private final GetProducerUseCase getProducerUseCase;
    private final SendSMSPort sendSMSPort;

    @Override
    public void sendSMSToReset(String dni, String message) {
        var producer = getProducerUseCase.getProducer(dni);
        sendSMSPort.sendSMS(producer.getPhone(), message);
    }
}
