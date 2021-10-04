package org.sistema.arroz.riceservice.modules.products.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;
import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.PROD_03_MESSAGE;

@Getter
public class ProductStockMinBrokenException extends RuntimeException implements UserInputException {
    private final String code = "PROD_03";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        String productName;
        Integer stock;
        Integer offset;
    }

    public ProductStockMinBrokenException(Long productId, String productName, Integer stock, Integer offset){
        super();
        this.message = String.format(PROD_03_MESSAGE, productId, offset);
        this.data = new Data(productName, stock, offset);
    }
}
