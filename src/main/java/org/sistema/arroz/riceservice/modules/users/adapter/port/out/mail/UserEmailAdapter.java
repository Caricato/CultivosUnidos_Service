package org.sistema.arroz.riceservice.modules.users.adapter.port.out.mail;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.helpers.MailSenderHelper;
import org.sistema.arroz.riceservice.hexagonal.helpers.MailType;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.sistema.arroz.riceservice.modules.users.application.port.out.SendMailToResetPort;
import org.sistema.arroz.riceservice.modules.users.application.port.out.SendMailToWelcomePort;

import javax.mail.MessagingException;
import java.util.HashMap;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserEmailAdapter implements SendMailToResetPort, SendMailToWelcomePort {
    private final MailSenderHelper mailSenderHelper;

    @Override
    public void sendMailToReset(String emailTo, String url, String token) throws MessagingException {
        var mailSender = mailSenderHelper.getMailSenderHelper();
        var completeUrl = url+"/"+token;
        mailSenderHelper.sendMail(mailSender, "juandiegovd99@gmail.com", emailTo, MailType.RESET, completeUrl, null);
    }

    @Override
    public void sendMailToWelcome(String url, String token, Producer producer) throws MessagingException {
        var mailSender = mailSenderHelper.getMailSenderHelper();
        var completeUrl = url+"/"+token;
        var map = new HashMap<>();
        map.put("communityName", producer.getCommunity().getCommunityName());
        mailSenderHelper.sendMail(mailSender, "juandiegovd99@gmail.com", producer.getEmail(), MailType.FIRST_LOGIN, completeUrl, map);
    }
}
