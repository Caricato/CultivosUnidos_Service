package org.sistema.arroz.riceservice.modules.users.application.port.in;

import javax.mail.MessagingException;

public interface SendMailToResetUseCase {
    void sendMailToReset(String dni, String url) throws MessagingException;
}
