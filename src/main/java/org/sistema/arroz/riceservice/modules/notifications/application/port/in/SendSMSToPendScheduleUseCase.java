package org.sistema.arroz.riceservice.modules.notifications.application.port.in;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;

import java.util.List;

public interface SendSMSToPendScheduleUseCase {
    void sendSMSToPend(Schedule schedule, List<ScheduleDetail> scheduleDetails);
}
