package org.sistema.arroz.riceservice.hexagonal.helpers;

import com.twilio.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.SMSConfig;
import org.sistema.arroz.riceservice.hexagonal.HelperAdapter;
import org.sistema.arroz.riceservice.hexagonal.sms.SMS;

@HelperAdapter
@RequiredArgsConstructor
public class SMSHelper {
    private final SMSConfig smsConfig;

    public void smsSubmit(String phoneNumber, String message){
        try{
            smsConfig.send(SMS.builder().message(message).to(phoneNumberPeru(phoneNumber)).build());
        }
        catch(ApiException e){
            System.out.println("Failed to send sms");
            throw e;
        }
    }

    private String phoneNumberPeru(String phoneNumber){
        return "+51"+phoneNumber;
    }
}
