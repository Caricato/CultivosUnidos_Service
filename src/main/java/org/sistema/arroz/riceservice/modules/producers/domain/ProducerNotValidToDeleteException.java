package org.sistema.arroz.riceservice.modules.producers.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.USR_09_MESSAGE;

@Getter
public class ProducerNotValidToDeleteException extends RuntimeException implements UserInputException {

    private final String code = "USR_09";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long producerId;
    }

    public ProducerNotValidToDeleteException(Long producerId){
        super();
        this.message = String.format(USR_09_MESSAGE, producerId);
        this.data = producerId;
    }
}
