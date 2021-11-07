package org.sistema.arroz.riceservice.modules.producers.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

@Getter
public class ProducerEmailException extends RuntimeException implements UserInputException {
    private final String code = "USR_07";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        String email;
    }

    public ProducerEmailException(String email){
        super();
        this.message = String.format(ErrorMessages.USR_07_MESSAGE, email);
        this.data = email;
    }
}
