package org.sistema.arroz.riceservice.modules.producers.application.port.in;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

public interface EditProducerUseCase {
    Producer editProducer(Long producerId, ProducerToEdit producerToEdit);
}
