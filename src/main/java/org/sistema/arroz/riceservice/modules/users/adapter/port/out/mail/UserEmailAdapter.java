package org.sistema.arroz.riceservice.modules.users.adapter.port.out.mail;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.helpers.MailSenderHelper;
import org.sistema.arroz.riceservice.hexagonal.helpers.MailType;
import org.sistema.arroz.riceservice.modules.users.application.port.out.SendMailToResetPort;

import javax.mail.MessagingException;
@PersistenceAdapter
@RequiredArgsConstructor
public class UserEmailAdapter implements SendMailToResetPort {
    private final MailSenderHelper mailSenderHelper;

    @Override
    public void sendMailToReset(String emailTo, String url, String token) throws MessagingException {
        var mailSender = mailSenderHelper.getMailSenderHelper();
        var completeUrl = url+"/"+token;
        mailSenderHelper.sendMail(mailSender, "juandiegovd99@gmail.com", emailTo, MailType.RESET, completeUrl);
    }
}
