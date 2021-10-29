package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

@Getter
public class ScheduleSuppliesException extends RuntimeException implements UserInputException {
    private final String code = "CRG_04";
    private final String message;
    private final Object data;

    @Value
    static class Data{
    }

    public ScheduleSuppliesException() {
        super();
        this.message = ErrorMessages.CRG_04_MESSAGE;
        this.data = new Data();
    }
}