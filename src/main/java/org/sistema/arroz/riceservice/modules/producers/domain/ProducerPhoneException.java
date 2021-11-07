package org.sistema.arroz.riceservice.modules.producers.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

@Getter
public class ProducerPhoneException extends RuntimeException implements UserInputException {
    private final String code = "USR_08";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        String phone;
    }

    public ProducerPhoneException(String phone){
        super();
        this.message = String.format(ErrorMessages.USR_08_MESSAGE, phone);
        this.data = phone;
    }
}
