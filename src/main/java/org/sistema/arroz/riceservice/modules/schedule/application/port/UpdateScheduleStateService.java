package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.UpdateScheduleStateUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.UpdateScheduleStatePort;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class UpdateScheduleStateService implements UpdateScheduleStateUseCase {
    private final UpdateScheduleStatePort updateScheduleStatePort;

    @Override
    public List<Schedule> updateScheduleState() {
        var schedulesActivated = updateScheduleStatePort.activateSchedules();
        var schedulesFinished = updateScheduleStatePort.finishSchedules();
        var schedulesUpdated = new ArrayList<Schedule>();
        schedulesUpdated.addAll(schedulesActivated);
        schedulesUpdated.addAll(schedulesFinished);
        return schedulesUpdated;
    }
}
