package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.GetScheduleUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.GetSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

@UseCase
@RequiredArgsConstructor
public class GetScheduleService implements GetScheduleUseCase {
    private final GetSchedulePort getSchedulePort;

    @Override
    public Schedule getSchedule(Long scheduleId) {
        return getSchedulePort.getSchedule(scheduleId);
    }
}
