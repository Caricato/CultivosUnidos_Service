package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ValidateProducerToRegisterUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.ValidateProducerToRegisterPort;
import org.sistema.arroz.riceservice.modules.producers.domain.ProducerDNIException;

@UseCase
@RequiredArgsConstructor
public class ValidateProducerToRegisterService implements ValidateProducerToRegisterUseCase {
    private final ValidateProducerToRegisterPort validateProducerToRegisterPort;

    @Override
    public void validateProducer(String dni) {
        var result = validateProducerToRegisterPort.validateProducer(dni);
        if (result.isPresent()) throw new ProducerDNIException(dni);
    }
}
