package org.sistema.arroz.riceservice.modules.products.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.PROD_02_MESSAGE;

@Getter
public class ProductPriceNotFoundException extends RuntimeException implements NotFoundException {
    private final String code = "PROD_02";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long productId;
        Integer month;
    }

    public ProductPriceNotFoundException(Long productId, Integer month){
        super();
        this.message = String.format(PROD_02_MESSAGE, productId, month);
        this.data = new Data(productId, month);
    }
}
