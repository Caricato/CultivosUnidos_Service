package org.sistema.arroz.riceservice.modules.notifications.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.ThirdPartyException;

@Getter
public class SendSMSException extends RuntimeException implements ThirdPartyException {
    private final String code = "SMS_01";
    private final String message;
    private final Object data;

    @Value
    static class Data{
        String message;
    }

    public SendSMSException(String message) {
        super();
        this.message = String.format(ErrorMessages.SMS_01_MESSAGE, message);
        this.data = new Data(message);
    }
}
