package org.sistema.arroz.riceservice.modules.producers.application.port.out;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

import java.util.Optional;

public interface ValidateProducerToRegisterPort {
    Optional<Producer> validateProducerByDNI(String dni);
    Optional<Producer> validateProducerByEmail(String email);
    Optional<Producer> validateProducerByPhone(String number);
}
