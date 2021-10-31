package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.CRG_05_MESSAGE;

@Getter
public class ScheduleNotFoundException extends RuntimeException implements NotFoundException {
    private final String code = "CRG_05";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long scheduleId;
    }

    public ScheduleNotFoundException(Long scheduleId){
        super();
        this.message = String.format(CRG_05_MESSAGE, scheduleId);
        this.data = new Data(scheduleId);
    }
}
