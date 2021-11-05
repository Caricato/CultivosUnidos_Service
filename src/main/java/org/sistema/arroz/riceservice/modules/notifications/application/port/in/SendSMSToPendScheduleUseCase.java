package org.sistema.arroz.riceservice.modules.notifications.application.port.in;

import org.sistema.arroz.riceservice.modules.schedule.application.port.out.ScheduleDetailToRegister;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.util.List;

public interface SendSMSToPendScheduleUseCase {
    void sendSMSToPend(Schedule schedule, List<ScheduleDetailToRegister> scheduleDetails);
}
