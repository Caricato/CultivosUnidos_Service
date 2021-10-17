package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.EditProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToEdit;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.EditProducerPort;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

@UseCase
@RequiredArgsConstructor
public class EditProducerService implements EditProducerUseCase {
    private final EditProducerPort editProducerPort;

    @Override
    public Producer editProducer(Long producerId, ProducerToEdit producerToEdit) {
        return editProducerPort.editProducer(producerId, producerToEdit);
    }
}
