package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.util.List;

public interface ValidateProductSchedulesPort {
    List<Schedule> validateProductSchedules(Long productId);
}
