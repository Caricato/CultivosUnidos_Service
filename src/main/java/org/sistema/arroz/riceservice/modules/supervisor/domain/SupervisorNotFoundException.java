package org.sistema.arroz.riceservice.modules.supervisor.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;
@Getter
public class SupervisorNotFoundException extends RuntimeException implements UserInputException {
    private final String code = "USR_06";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        String dni;
    }

    public SupervisorNotFoundException(String dni){
        super();
        this.message = String.format(ErrorMessages.USR_06_MESSAGE, dni);
        this.data = dni;
    }
}