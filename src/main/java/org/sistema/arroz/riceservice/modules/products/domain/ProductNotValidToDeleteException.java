package org.sistema.arroz.riceservice.modules.products.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.PROD_04_MESSAGE;

@Getter
public class ProductNotValidToDeleteException extends RuntimeException implements UserInputException {
    private final String code = "PROD_04";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long productId;
    }

    public ProductNotValidToDeleteException(Long productId){
        super();
        this.message = String.format(PROD_04_MESSAGE, productId);
        this.data = productId;
    }
}
