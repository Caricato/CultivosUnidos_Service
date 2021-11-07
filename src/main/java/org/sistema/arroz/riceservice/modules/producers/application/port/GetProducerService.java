package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.GetProducerPort;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.ValidateProducerToRegisterPort;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.sistema.arroz.riceservice.modules.producers.domain.ProducerNotFoundException;

@UseCase
@RequiredArgsConstructor
public class GetProducerService implements GetProducerUseCase {
    private final GetProducerPort getProducerPort;
    private final ValidateProducerToRegisterPort validateProducerToRegisterPort;

    @Override
    public Producer getProducer(Long producerId) {
        return getProducerPort.getProducer(producerId);
    }

    @Override
    public Producer getProducer(String dni) {
        var producer = validateProducerToRegisterPort.validateProducerByDNI(dni);
        if (producer.isEmpty()) throw new ProducerNotFoundException(-1L);
        return producer.get();
    }
}
