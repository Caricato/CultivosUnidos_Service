package org.sistema.arroz.riceservice.modules.users.application.port.out;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

public interface SendSMSToResetPort {
    void sendSMSToResetPassword(Producer producer);
}
