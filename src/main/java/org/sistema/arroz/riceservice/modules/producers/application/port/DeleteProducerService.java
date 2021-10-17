package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.DeleteProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.DeleteProducerPort;

@UseCase
@RequiredArgsConstructor
public class DeleteProducerService implements DeleteProducerUseCase {
    private final DeleteProducerPort deleteProducerPort;

    @Override
    public void deleteProducer(Long producerId) {
        deleteProducerPort.deleteProducer(producerId);
    }
}
