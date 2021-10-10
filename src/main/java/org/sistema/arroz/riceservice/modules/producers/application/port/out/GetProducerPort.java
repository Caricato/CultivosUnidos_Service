package org.sistema.arroz.riceservice.modules.producers.application.port.out;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

public interface GetProducerPort {
    Producer getProducer(Long producerId);
    Producer getProducerByUser(Long userId);
}
