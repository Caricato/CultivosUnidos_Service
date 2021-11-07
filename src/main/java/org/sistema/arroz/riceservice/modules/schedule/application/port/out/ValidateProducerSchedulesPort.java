package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;

import java.util.List;

public interface ValidateProducerSchedulesPort {
    List<ScheduleDetail> validateProducerSchedules(Long producerId);
}
