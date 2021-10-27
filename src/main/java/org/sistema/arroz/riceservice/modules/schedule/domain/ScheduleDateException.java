package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

import java.time.LocalDate;

@Getter
public class ScheduleDateException extends RuntimeException implements UserInputException {
    private final String code = "CRG_01";
    private final String message;
    private final Object data;

    @Value
    static class Data{
        LocalDate date;
    }

    public ScheduleDateException(LocalDate date) {
        super();
        this.message = ErrorMessages.CRG_01_MESSAGE;
        this.data = new Data(date);
    }
}
