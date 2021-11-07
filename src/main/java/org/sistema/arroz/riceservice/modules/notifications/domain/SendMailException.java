package org.sistema.arroz.riceservice.modules.notifications.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.ThirdPartyException;
@Getter
public class SendMailException extends RuntimeException implements ThirdPartyException {
    private final String code = "MAIL_01";
    private final String message;
    private final Object data;

    @Value
    static class Data{
        String message;
    }

    public SendMailException(String message) {
        super();
        this.message = String.format(ErrorMessages.MAIL_01_MESSAGE, message);
        this.data = new Data(message);
    }
}
