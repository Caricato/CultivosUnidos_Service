package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

import java.util.ArrayList;
import java.util.List;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.SUP_03_MESSAGE;

@Getter
public class SupplyNotValidToDeleteException extends RuntimeException implements UserInputException {
    private final String code = "SUP_03";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        List<String> products;
    }

    private List<String> productNames(List<Product> products){
        var productNames = new ArrayList<String>(products.size());
        for (Product product: products){
            productNames.add(product.getProductName());
        }
        return productNames;
    }

    public SupplyNotValidToDeleteException(Long supplyId, List<Product> products){
        super();
        this.message = String.format(SUP_03_MESSAGE, supplyId);
        this.data = new Data(productNames(products));
    }
}
