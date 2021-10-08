package org.sistema.arroz.riceservice.modules.producers.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.USR_02_MESSAGE;

@Getter
public class ProducerNotFoundException extends RuntimeException implements NotFoundException {

    private final String code = "USR_02";
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

    public ProducerNotFoundException(Long producerId){
        super();
        this.message = String.format(USR_02_MESSAGE, producerId);
        this.data = producerId;
    }
}
