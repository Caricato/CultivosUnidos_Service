package org.sistema.arroz.riceservice.modules.users.application.port.in;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

public interface SendSMSToResetUseCase {
    void sendSMSToResetPassword(String dni);
}
