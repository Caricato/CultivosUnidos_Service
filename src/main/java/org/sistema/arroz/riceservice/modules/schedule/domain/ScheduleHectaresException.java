package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

import java.time.LocalDate;

@Getter
public class ScheduleHectaresException extends RuntimeException implements UserInputException {
    private final String code = "CRG_02";
    private final String message;
    private final Object data;

    @Value
    static class Data{
        Double hectares;
        Double actualHectares;
    }

    public ScheduleHectaresException(Double hectares, Double actualHectares) {
        super();
        this.message = "Schedule date is not valid";
        this.data = new Data(hectares, actualHectares);
    }
}
