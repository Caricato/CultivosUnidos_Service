package org.sistema.arroz.riceservice.modules.users.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.USR_05_MESSAGE;

@Getter
public class UsernameNotFoundException extends RuntimeException implements UserInputException {

    private final String code = "USR_05";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long username;
    }

    public UsernameNotFoundException(String username){
        super();
        this.message = String.format(USR_05_MESSAGE, username);
        this.data = username;
    }
}