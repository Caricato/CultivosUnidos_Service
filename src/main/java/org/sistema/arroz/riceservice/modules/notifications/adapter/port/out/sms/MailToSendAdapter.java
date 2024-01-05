package org.sistema.arroz.riceservice.modules.notifications.adapter.port.out.sms;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.CustomConfig;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.helpers.MailSenderHelper;
import org.sistema.arroz.riceservice.modules.notifications.application.port.out.SendMailPort;
import org.sistema.arroz.riceservice.modules.notifications.domain.SendMailException;

import java.util.Map;

@PersistenceAdapter
@RequiredArgsConstructor
public class MailToSendAdapter implements SendMailPort {
    private final MailSenderHelper mailSenderHelper;
    private final CustomConfig customConfig;

    @Override
    public void sendMail(String emailTo, String templateMail, String subject, Map<String, ?> parameters) {
        if (customConfig.getSendMail()){
            try{
                mailSenderHelper.sendMail(emailTo, templateMail, subject, parameters);
            }catch (Exception ex){
                throw new SendMailException(ex.getMessage());
            }
        }
    }
}
