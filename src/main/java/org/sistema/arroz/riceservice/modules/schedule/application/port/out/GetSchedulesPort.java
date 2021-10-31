package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.util.List;

public interface GetSchedulesPort {
    List<Schedule> getSchedules(Long communityId);
}
