package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages;
import org.sistema.arroz.riceservice.hexagonal.errors.UserInputException;

@Getter
public class ScheduleDeleteException extends RuntimeException implements UserInputException {
    private final String code = "CRG_07";
    private final String message;
    private final Object data;

    @Value
    static class Data{
        Long scheduleId;
    }

    public ScheduleDeleteException(Long scheduleId) {
        super();
        this.message = String.format(ErrorMessages.CRG_07_MESSAGE, scheduleId);
        this.data = new Data(scheduleId);
    }
}