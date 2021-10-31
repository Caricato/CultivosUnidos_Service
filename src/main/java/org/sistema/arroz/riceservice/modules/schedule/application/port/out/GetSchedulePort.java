package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

public interface GetSchedulePort {
    Schedule getSchedule(Long scheduleId);
}
