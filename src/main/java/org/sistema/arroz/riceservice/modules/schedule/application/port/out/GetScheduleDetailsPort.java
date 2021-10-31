package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;

import java.util.List;

public interface GetScheduleDetailsPort {
    List<ScheduleDetail> getScheduleDetails(Long scheduleId);
}
