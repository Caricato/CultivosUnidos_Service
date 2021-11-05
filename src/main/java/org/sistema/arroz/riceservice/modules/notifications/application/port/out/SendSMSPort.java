package org.sistema.arroz.riceservice.modules.notifications.application.port.out;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

public interface SendSMSPort {
    void sendSMS(String phone, String message);
}
