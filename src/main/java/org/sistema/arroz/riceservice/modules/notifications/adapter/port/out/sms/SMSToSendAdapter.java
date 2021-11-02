package org.sistema.arroz.riceservice.modules.notifications.adapter.port.out.sms;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.helpers.SMSHelper;
import org.sistema.arroz.riceservice.modules.notifications.application.port.out.SendSMSPort;

@PersistenceAdapter
@RequiredArgsConstructor
public class SMSToSendAdapter implements SendSMSPort {
    private final SMSHelper smsHelper;

    @Override
    public void sendSMS(String phone, String message) {;
        smsHelper.smsSubmit(phone, message);
    }
}
