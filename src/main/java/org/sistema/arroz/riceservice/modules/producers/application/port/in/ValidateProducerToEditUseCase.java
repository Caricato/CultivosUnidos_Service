package org.sistema.arroz.riceservice.modules.producers.application.port.in;

public interface ValidateProducerToEditUseCase {
    void validateProducer(Long producerId, ProducerToEdit producerToEdit);
}
