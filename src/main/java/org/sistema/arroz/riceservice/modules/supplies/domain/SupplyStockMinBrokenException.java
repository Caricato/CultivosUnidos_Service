package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.SUP_04_MESSAGE;

@Getter
public class SupplyStockMinBrokenException extends RuntimeException implements UserInputException {
    private final String code = "SUP_04";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        String supplyName;
        Double stock;
        Double stockMin;
        Double offset;
    }

    public SupplyStockMinBrokenException(Long supplyId, String supplyName, Double stock, Double stockMin, Double offset){
        super();
        this.message = String.format(SUP_04_MESSAGE, supplyId, stockMin);
        this.data = new Data(supplyName, stock, stockMin, offset);
    }
}
