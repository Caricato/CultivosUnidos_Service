package org.sistema.arroz.riceservice.modules.token.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

import java.io.Serializable;

@Getter
public class InvalidTokenException extends RuntimeException implements UserInputException {
    private final String code = "TKN_001";
    private final String message;
    private final Object data;

    @Value
    static class Data implements Serializable {
    }

    public InvalidTokenException() {
        super();
        this.message = "Token sent is invalid";
        this.data = new InvalidTokenException.Data();
    }
}
