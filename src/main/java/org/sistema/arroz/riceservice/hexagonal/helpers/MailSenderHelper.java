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

import java.util.HashMap;

import static org.sistema.arroz.riceservice.hexagonal.reports.Templates.TEMPLATE_EMAIL_RESET;
import static org.sistema.arroz.riceservice.hexagonal.reports.Templates.TEMPLATE_WELCOME_RESET;

@Data
@Component
@RequiredArgsConstructor
public class MailSenderHelper {
    private final MailConfig mailConfig;
    private final SpringTemplateEngine templateEngine;

    public JavaMailSenderImpl getMailSenderHelper(){
        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailConfig.getHost());
        mailSender.setPort(mailConfig.getPort());
        mailSender.setUsername("0e441273968808");
        mailSender.setPassword(mailConfig.getPassword());
        return mailSender;
    }

    public void sendMail(JavaMailSenderImpl mailSender, String emailFrom, String emailTo, MailType type, String completeUrl, HashMap map) throws MessagingException {
        var mimeMessage = mailSender.createMimeMessage();
        var mailMessage = new MimeMessageHelper(mimeMessage);
        mailMessage.setFrom(emailFrom);
        mailMessage.setTo(emailTo);
        if (type.equals(MailType.RESET)){
            var context = new Context();
            context.setVariable("url", completeUrl);
            var html = templateEngine.process(TEMPLATE_EMAIL_RESET, context);
            mailMessage.setSubject("Cultivos Unidos - Restablecer contraseña");
            mailMessage.setText(html, true);
            mailSender.send(mimeMessage);
        }
        if (type.equals(MailType.FIRST_LOGIN)) {
            var context = new Context();
            var newMap = new HashMap<String, Object>();
            newMap.put("url", completeUrl);
            newMap.put("communityName", map.get("communityName"));
            context.setVariables(newMap);
            var html = templateEngine.process(TEMPLATE_WELCOME_RESET, context);
            mailMessage.setSubject("Cultivos Unidos - Bienvenido productor!");
            mailMessage.setText(html, true);
            mailSender.send(mimeMessage);
        }
    }
}
