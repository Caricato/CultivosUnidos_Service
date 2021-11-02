package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryDetailToRegister;

import java.util.List;

public interface ValidateStockUseCase {
    List<MerchandiseEntryDetailToRegister> validateStockSchedule(Long communityId, ScheduleToRegister scheduleToRegister);
}
