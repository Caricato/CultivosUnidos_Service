package org.sistema.arroz.riceservice.hexagonal.helpers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.MailConfig;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;

@Data
@RequiredArgsConstructor
public class MailSenderHelper {
    private final MailConfig mailConfig;

    public JavaMailSenderImpl getMailSenderHelper(){
        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailConfig.getHost());
        mailSender.setPort(mailConfig.getPort());
        mailSender.setUsername(mailConfig.getUsername());
        mailSender.setPassword(mailConfig.getPassword());
        return mailSender;
    }

    public void sendMail(JavaMailSenderImpl mailSender, String emailFrom, String emailTo, MailType type) throws MessagingException {
        var mimeMessage = mailSender.createMimeMessage();
        var mailMessage = new MimeMessageHelper(mimeMessage);
        mailMessage.setFrom(emailFrom);
        mailMessage.setTo(emailTo);
        if (type.equals(MailType.RESET)){
            mailMessage.setSubject("Cultivos Unidos - Restablecer contraseña");
            mailMessage.setText("classpath:templates/forgotPassword.html", true);
            mailSender.send(mimeMessage);
        }
    }
}
