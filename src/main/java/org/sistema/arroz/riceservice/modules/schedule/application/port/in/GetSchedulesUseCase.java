package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.util.List;

public interface GetSchedulesUseCase {
    List<Schedule> getSchedules(Long communityId);
}
