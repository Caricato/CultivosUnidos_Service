package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

@Getter
public class ScheduleStockException extends RuntimeException implements UserInputException {
    private final String code = "CRG_02";
    private final String message;
    private final Object data;

    @Value
    static class Data{
        Long productId;
        Double hectares;
    }

    public ScheduleStockException(Long productId, Double hectares) {
        super();
        this.message = String.format(ErrorMessages.CRG_02_MESSAGE, hectares, productId);
        this.data = new Data(productId, hectares);
    }
}
