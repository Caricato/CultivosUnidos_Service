package org.sistema.arroz.riceservice.modules.sales.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;
import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.SALE_02_MESSAGE;

@Getter
public class SaleNotFoundException extends RuntimeException implements NotFoundException {
    private final String code = "SALE_02";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long saleId;
    }

    public SaleNotFoundException(Long saleId){
        super();
        this.message = String.format(SALE_02_MESSAGE, saleId);
        this.data = new Data(saleId);
    }
}
