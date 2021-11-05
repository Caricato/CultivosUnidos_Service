package org.sistema.arroz.riceservice.modules.notifications.adapter.port.out.sms;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.CustomConfig;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.helpers.SMSHelper;
import org.sistema.arroz.riceservice.modules.notifications.application.port.out.SendSMSPort;

@PersistenceAdapter
@RequiredArgsConstructor
public class SMSToSendAdapter implements SendSMSPort {
    private final SMSHelper smsHelper;
    private final CustomConfig config;

    @Override
    public void sendSMS(String phone, String message) {;
        if (config.getSendSMS()) smsHelper.smsSubmit(phone, message);
        else System.out.println("SMS workaround successful!");
    }
}
