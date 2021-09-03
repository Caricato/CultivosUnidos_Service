package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

@Getter
public class SupplyNotFoundException extends RuntimeException implements NotFoundException {
    private final String code = "SUP_02";
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
        this.message = String.format("Supply with the id: %d not found", supplyId);
        this.data = supplyId;
    }
}
