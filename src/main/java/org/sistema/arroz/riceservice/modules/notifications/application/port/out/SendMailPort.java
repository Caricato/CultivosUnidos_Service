package org.sistema.arroz.riceservice.modules.notifications.application.port.out;

import java.util.Map;

public interface SendMailPort {
    void sendMail(String emailTo, String templateMail, String subject, Map<String, ?> parameters);
}
