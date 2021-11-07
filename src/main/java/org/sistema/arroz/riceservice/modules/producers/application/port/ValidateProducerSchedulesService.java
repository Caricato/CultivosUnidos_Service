package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ValidateProducerSchedulesUseCase;
import org.sistema.arroz.riceservice.modules.producers.domain.ProducerNotValidToDeleteException;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.ValidateProducerSchedulesPort;

@UseCase
@RequiredArgsConstructor
public class ValidateProducerSchedulesService implements ValidateProducerSchedulesUseCase {
    private final ValidateProducerSchedulesPort validateProducerSchedulesPort;

    @Override
    public void validateProducerSchedules(Long producerId) {
        var schedules = validateProducerSchedulesPort.validateProducerSchedules(producerId);
        if (!schedules.isEmpty()) throw new ProducerNotValidToDeleteException(producerId);
    }
}
