package org.sistema.arroz.riceservice.modules.producers.application.port.out;

import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToEdit;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

public interface EditProducerPort {
    Producer editProducer(Long producerId, ProducerToEdit producerToEdit);
}
