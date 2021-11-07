package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.DeleteProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ValidateProducerSchedulesUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.DeleteProducerPort;

@UseCase
@RequiredArgsConstructor
public class DeleteProducerService implements DeleteProducerUseCase {
    private final DeleteProducerPort deleteProducerPort;
    private final ValidateProducerSchedulesUseCase validateProducerSchedulesUseCase;

    @Override
    public void deleteProducer(Long producerId) {
        validateProducerSchedulesUseCase.validateProducerSchedules(producerId);
        deleteProducerPort.deleteProducer(producerId);
    }
}
