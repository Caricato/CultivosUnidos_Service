package org.sistema.arroz.riceservice.modules.parameters.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.InitialDataException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.PARAM_01_MESSAGE;

@Getter
public class ParametersNotFoundException extends RuntimeException implements InitialDataException {

    private final String code = "PARAM_01";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
    }

    public ParametersNotFoundException(){
        super();
        this.message = PARAM_01_MESSAGE;
        this.data = new Data();
    }
}
