package org.sistema.arroz.riceservice.modules.producers.application.port.in;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

public interface GetProducerUseCase {
    Producer getProducer(Long producerId);
    Producer getProducer(String dni);
}
