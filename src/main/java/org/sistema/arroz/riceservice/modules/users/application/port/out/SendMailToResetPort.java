package org.sistema.arroz.riceservice.modules.users.application.port.out;

import javax.mail.MessagingException;

public interface SendMailToResetPort {
    void sendMailToReset(String emailTo, String url, String token) throws MessagingException;
}
