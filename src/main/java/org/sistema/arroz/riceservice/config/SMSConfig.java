package org.sistema.arroz.riceservice.config;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import lombok.Getter;
import lombok.Setter;
import org.sistema.arroz.riceservice.hexagonal.sms.SMS;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "twilio")
public class SMSConfig {
    private String sid;
    private String token;
    private String phone;

    public void send(SMS sms){
        Twilio.init(sid, token);
        var message = Message.creator(
                new PhoneNumber(sms.getTo()), new PhoneNumber(phone), sms.getMessage()).create();
        System.out.println("here is my id:"+message.getSid());
    }
}
