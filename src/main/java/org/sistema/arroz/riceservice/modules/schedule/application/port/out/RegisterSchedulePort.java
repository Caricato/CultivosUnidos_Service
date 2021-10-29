package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ScheduleToRegister;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

public interface RegisterSchedulePort {
    Schedule registerSchedule(ScheduleToRegister scheduleToRegister, Product product);
}
