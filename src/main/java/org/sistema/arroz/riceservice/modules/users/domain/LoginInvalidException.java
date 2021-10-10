package org.sistema.arroz.riceservice.modules.users.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.USR_04_MESSAGE;

@Getter
public class LoginInvalidException extends RuntimeException implements UserInputException {
    private final String code = "USR_04";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        String username;
    }

    public LoginInvalidException(String username){
        super();
        this.message = USR_04_MESSAGE;
        this.data = new Data(username);
    }
}