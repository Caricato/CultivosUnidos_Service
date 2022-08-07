package org.sistema.arroz.riceservice.modules.users.adapter.port.out.mail;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.CustomConfig;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.helpers.MailSenderHelper;
import org.sistema.arroz.riceservice.hexagonal.helpers.MailType;
import org.sistema.arroz.riceservice.modules.notifications.application.port.out.SendMailPort;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.sistema.arroz.riceservice.modules.users.application.port.out.SendMailToResetPort;
import org.sistema.arroz.riceservice.modules.users.application.port.out.SendMailToWelcomePort;
import static org.sistema.arroz.riceservice.hexagonal.reports.Templates.*;

import java.util.HashMap;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserEmailAdapter implements SendMailToResetPort, SendMailToWelcomePort {
    private final SendMailPort sendMailPort;
    private final CustomConfig customConfig;

    @Override
    public void sendMailToReset(String emailTo, String url, String token) {
        if (customConfig.getSendMail()){
            var completeUrl = url+"/"+token;
            var map = new HashMap<String,String>();
            map.put("url", completeUrl);
            sendMailPort.sendMail(emailTo, TEMPLATE_EMAIL_RESET, "Cultivos Unidos - Restablecer contraseña", map);
        }
        else{
            System.out.println(token);
        }
    }

    @Override
    public void sendMailToWelcome(String url, String token, Producer producer) {
        var completeUrl = url+"/"+token;
        var map = new HashMap<String,String>();
        map.put("url", completeUrl);
        map.put("communityName", producer.getCommunity().getCommunityName());
        sendMailPort.sendMail(producer.getEmail(), TEMPLATE_WELCOME_RESET, "Cultivos Unidos - Bienvenido a la comunidad!", map);
    }
}
