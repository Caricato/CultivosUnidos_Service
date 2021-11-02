package org.sistema.arroz.riceservice.modules.notifications.application.port.in;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;

import java.util.List;

public interface SendSMSToFinishScheduleUseCase {
    void sendSMSToFinish(Schedule schedule, List<ScheduleDetail> scheduleDetails);
}
