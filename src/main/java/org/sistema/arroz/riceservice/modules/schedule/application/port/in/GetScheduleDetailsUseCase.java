package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;

import java.util.List;

public interface GetScheduleDetailsUseCase {
    List<ScheduleDetail> getScheduleDetails(Long scheduleId);
}
