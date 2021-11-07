package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.domain.ProducerNotValidToDeleteException;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ValidateProductToDeleteUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.ValidateProductSchedulesPort;

@UseCase
@RequiredArgsConstructor
public class ValidateProductToDeleteService implements ValidateProductToDeleteUseCase {
    private final ValidateProductSchedulesPort validateProductSchedulesPort;

    @Override
    public void validateProduct(Long productId) {
        var result = validateProductSchedulesPort.validateProductSchedules(productId);
        if (!result.isEmpty()) throw new ProducerNotValidToDeleteException(productId);
    }
}
