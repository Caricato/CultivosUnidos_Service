package org.sistema.arroz.riceservice.modules.users.application.port.in;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

import javax.mail.MessagingException;

public interface SendMailToWelcomeUseCase {
    void sendMailToWelcome(String dni, String url) throws MessagingException;
}
