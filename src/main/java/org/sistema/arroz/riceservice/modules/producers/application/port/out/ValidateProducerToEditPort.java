package org.sistema.arroz.riceservice.modules.producers.application.port.out;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

import java.util.Optional;

public interface ValidateProducerToEditPort {
    Optional<Producer> validateProducerByEmail(String email, Long producerId);
    Optional<Producer> validateProducerByPhone(String number, Long producerId);
}
