package org.sistema.arroz.riceservice.modules.agricultureCommunity.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.AGC_02_MESSAGE;

@Getter
public class AgricultureCommunitySupervisorException extends RuntimeException implements UserInputException {

    private final String code = "AGC_02";
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

    public AgricultureCommunitySupervisorException(String dni){
        super();
        this.message = String.format(AGC_02_MESSAGE, dni);
        this.data = dni;
    }
}