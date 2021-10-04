package org.sistema.arroz.riceservice.modules.sales.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductStockFailedDTO;

import java.util.List;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.SALE_01_MESSAGE;

@Getter
public class SaleInvalidException extends RuntimeException implements UserInputException {
    private final String code = "SALE_01";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        List<ProductStockFailedDTO> productStockFailedDTOList;
    }

    public SaleInvalidException(List<ProductStockFailedDTO> productStockFailedDTOList){
        super();
        this.message = SALE_01_MESSAGE;
        this.data = new Data(productStockFailedDTOList);
    }
}
