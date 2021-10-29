package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

public interface RegisterScheduleUseCase {
    Schedule registerSchedule(Long communityId, ScheduleToRegister scheduleToRegister);
}
