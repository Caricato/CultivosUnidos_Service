package org.sistema.arroz.riceservice.modules.users.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.USR_03_MESSAGE;

@Getter
public class UserNotFoundException extends RuntimeException implements NotFoundException {

    private final String code = "USR_03";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long userId;
    }

    public UserNotFoundException(Long userId){
        super();
        this.message = String.format(USR_03_MESSAGE, userId);
        this.data = userId;
    }
}
