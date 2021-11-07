package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.DeleteProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ValidateProducerSchedulesUseCase;

@UseCase
@RequiredArgsConstructor
public class DeleteProducerService implements DeleteProducerUseCase {
    private final DeleteProducerUseCase deleteProducerUseCase;
    private final ValidateProducerSchedulesUseCase validateProducerSchedulesUseCase;

    @Override
    public void deleteProducer(Long producerId) {
        validateProducerSchedulesUseCase.validateProducerSchedules(producerId);
        deleteProducerUseCase.deleteProducer(producerId);
    }
}
