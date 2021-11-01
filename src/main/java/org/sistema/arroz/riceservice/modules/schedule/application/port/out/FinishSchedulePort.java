package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

public interface FinishSchedulePort {
    Schedule finishSchedule(Long scheduleId);
}
