package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.GetProducerPort;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

@UseCase
@RequiredArgsConstructor
public class GetProducerService implements GetProducerUseCase {
    private final GetProducerPort getProducerPort;

    @Override
    public Producer getProducer(Long producerId) {
        return getProducerPort.getProducer(producerId);
    }
}
