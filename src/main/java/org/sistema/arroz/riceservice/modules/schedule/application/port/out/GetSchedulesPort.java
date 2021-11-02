package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface GetSchedulesPort {
    List<Schedule> getActiveSchedules(Long communityId, LocalDate yearDate, LocalDate endDate);
    List<Schedule> getFinishedSchedules(Long communityId, LocalDate yearDate, LocalDate endDate);
}
