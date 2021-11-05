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
import java.util.Map;


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
        mailSender.setUsername(mailConfig.getUsername());
        mailSender.setPassword(mailConfig.getPassword());
        return mailSender;
    }

    public void sendMail(String emailTo, String templateMail, String subject, Map<String, ?> map) throws MessagingException {
        var mailSender = this.getMailSenderHelper();
        var mimeMessage = mailSender.createMimeMessage();
        var mailMessage = new MimeMessageHelper(mimeMessage);
        mailMessage.setFrom("juandiegovd99@gmail.com");
        mailMessage.setTo(emailTo);
        var context = new Context();
        if (map != null && map.size() > 0){
            var newMap = new HashMap<String, Object>();
            for (var key: map.keySet()){
                newMap.put(key, map.get(key));
            }
            context.setVariables(newMap);
        }
        var html = templateEngine.process(templateMail, context);
        mailMessage.setSubject(subject);
        mailMessage.setText(html, true);
        mailSender.send(mimeMessage);
    }
}
