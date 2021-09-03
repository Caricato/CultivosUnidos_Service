package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

@Getter
public class SupplyStockInconsistencyException extends RuntimeException implements UserInputException {
    private final String code = "SUP_01";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Integer stock;
        Integer stockMin;
    }

    public SupplyStockInconsistencyException(Integer stock, Integer stockMin){
        super();
        this.message = String.format("%d is lower than %d. Validate your data please!", stock, stockMin);
        this.data = new Data(stock, stockMin);
    }
}