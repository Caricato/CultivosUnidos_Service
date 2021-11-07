package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToEdit;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ValidateProducerToEditUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.ValidateProducerToEditPort;
import org.sistema.arroz.riceservice.modules.producers.domain.ProducerEmailException;
import org.sistema.arroz.riceservice.modules.producers.domain.ProducerPhoneException;

@UseCase
@RequiredArgsConstructor
public class ValidateProducerToEditService implements ValidateProducerToEditUseCase {
    private final ValidateProducerToEditPort validateProducerToEditPort;

    @Override
    public void validateProducer(Long producerId, ProducerToEdit producerToEdit) {
        var result = validateProducerToEditPort.validateProducerByEmail(producerToEdit.getEmail(), producerId);
        if (result.isPresent()) throw new ProducerEmailException(producerToEdit.getEmail());
        result = validateProducerToEditPort.validateProducerByPhone(producerToEdit.getPhone(), producerId);
        if (result.isPresent()) throw new ProducerPhoneException(producerToEdit.getPhone());
    }
}
