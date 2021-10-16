package org.sistema.arroz.riceservice.modules.producers.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToRegister;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.USR_PROD_01_MESSAGE;

@Getter
public class RegisterProducerException extends RuntimeException implements UserInputException {
    private final String code = "USR_PROD_01";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        ProducerToRegister producer;
    }

    public RegisterProducerException(ProducerToRegister producer){
        super();
        this.message = USR_PROD_01_MESSAGE;
        this.data = producer;
    }
}