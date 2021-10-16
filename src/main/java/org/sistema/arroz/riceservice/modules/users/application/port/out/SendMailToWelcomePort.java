package org.sistema.arroz.riceservice.modules.users.application.port.out;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

import javax.mail.MessagingException;

public interface SendMailToWelcomePort {
    void sendMailToWelcome(String url, String token, Producer producer) throws MessagingException;
}
