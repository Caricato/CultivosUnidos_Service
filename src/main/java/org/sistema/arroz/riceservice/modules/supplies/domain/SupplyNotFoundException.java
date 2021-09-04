package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.SUP_01_MESSAGE;

@Getter
public class SupplyNotFoundException extends RuntimeException implements NotFoundException {
    private final String code = "SUP_01";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long supplyId;
    }

    public SupplyNotFoundException(Long supplyId){
        super();
        this.message = String.format(SUP_01_MESSAGE, supplyId);
        this.data = supplyId;
    }
}
