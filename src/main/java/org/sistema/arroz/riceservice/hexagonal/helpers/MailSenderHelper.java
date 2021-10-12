package org.sistema.arroz.riceservice.hexagonal.helpers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


import javax.mail.MessagingException;

@Data
@Component
@RequiredArgsConstructor
public class MailSenderHelper {
    private final MailConfig mailConfig;
    @Autowired
    private SpringTemplateEngine templateEngine;

    public JavaMailSenderImpl getMailSenderHelper(){
        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailConfig.getHost());
        mailSender.setPort(mailConfig.getPort());
        mailSender.setUsername("0e441273968808");
        mailSender.setPassword(mailConfig.getPassword());
        return mailSender;
    }

    public void sendMail(JavaMailSenderImpl mailSender, String emailFrom, String emailTo, MailType type, String completeUrl) throws MessagingException {
        var mimeMessage = mailSender.createMimeMessage();
        var mailMessage = new MimeMessageHelper(mimeMessage);
        mailMessage.setFrom(emailFrom);
        mailMessage.setTo(emailTo);
        if (type.equals(MailType.RESET)){
            var context = new Context();
            context.setVariable("url", completeUrl);
            var html = templateEngine.process("forgotPassword", context);
            mailMessage.setSubject("Cultivos Unidos - Restablecer contraseña");
            mailMessage.setText(html, true);
            mailSender.send(mimeMessage);
        }
    }
}
