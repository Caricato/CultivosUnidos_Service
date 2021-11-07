package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToRegister;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ValidateProducerToRegisterUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.ValidateProducerToRegisterPort;
import org.sistema.arroz.riceservice.modules.producers.domain.ProducerDNIException;
import org.sistema.arroz.riceservice.modules.producers.domain.ProducerEmailException;
import org.sistema.arroz.riceservice.modules.producers.domain.ProducerPhoneException;

@UseCase
@RequiredArgsConstructor
public class ValidateProducerToRegisterService implements ValidateProducerToRegisterUseCase {
    private final ValidateProducerToRegisterPort validateProducerToRegisterPort;

    @Override
    public void validateProducer(ProducerToRegister producerToRegister) {
        var result = validateProducerToRegisterPort.validateProducerByDNI(producerToRegister.getDni());
        if (result.isPresent()) throw new ProducerDNIException(producerToRegister.getDni());
        result = validateProducerToRegisterPort.validateProducerByEmail(producerToRegister.getEmail());
        if (result.isPresent()) throw new ProducerEmailException(producerToRegister.getEmail());
        result = validateProducerToRegisterPort.validateProducerByPhone(producerToRegister.getPhone());
        if (result.isPresent()) throw new ProducerPhoneException(producerToRegister.getPhone());
    }
}
