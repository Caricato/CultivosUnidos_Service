package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.Getter;
import lombok.Value;
import org.sistema.arroz.riceservice.hexagonal.errors.NotFoundException;

import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.CRG_06_MESSAGE;

@Getter
public class ScheduleDetailNotFoundException extends RuntimeException implements NotFoundException {
    private final String code = "CRG_06";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long scheduleDetailId;
    }

    public ScheduleDetailNotFoundException(Long scheduleDetailId){
        super();
        this.message = String.format(CRG_06_MESSAGE, scheduleDetailId);
        this.data = new ScheduleNotFoundException.Data(scheduleDetailId);
    }
}
