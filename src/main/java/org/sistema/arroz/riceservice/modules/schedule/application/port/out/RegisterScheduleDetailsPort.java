package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;

import java.util.List;

public interface RegisterScheduleDetailsPort {
    List<ScheduleDetail> registerScheduleDetails(List<ScheduleDetailToRegister> scheduleDetailsToRegister, Schedule schedule);
}
