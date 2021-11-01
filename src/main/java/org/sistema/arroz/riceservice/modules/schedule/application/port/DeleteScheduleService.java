package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.DeleteScheduleUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.DeleteScheduleDetailsPort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.DeleteSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.GetSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDeleteException;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetailNotFoundException;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleType;

@UseCase
@RequiredArgsConstructor
public class DeleteScheduleService implements DeleteScheduleUseCase {
    private final GetSchedulePort getSchedulePort;
    private final DeleteSchedulePort deleteSchedulePort;
    private final DeleteScheduleDetailsPort deleteScheduleDetailsPort;

    @Override
    public void deleteSchedule(Long scheduleId) {
        var schedule = getSchedulePort.getSchedule(scheduleId);
        if (schedule == null || !schedule.getState().equals(ScheduleType.PENDING))
            throw new ScheduleDeleteException(scheduleId);
        deleteScheduleDetailsPort.deleteScheduleDetails(scheduleId);
        deleteSchedulePort.deleteSchedule(scheduleId);
    }
}
