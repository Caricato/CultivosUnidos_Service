package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.util.List;

public interface UpdateScheduleStatePort {
     List<Schedule> activateSchedules();
     List<Schedule> finishSchedules();
}
