package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import org.sistema.arroz.riceservice.modules.schedule.application.port.out.ScheduleDetailToRegister;

import java.util.List;

public interface ValidateHectaresUseCase {
    List<ScheduleDetailToRegister> validateHectares(Long communityId, ScheduleToRegister scheduleToRegister);
}
