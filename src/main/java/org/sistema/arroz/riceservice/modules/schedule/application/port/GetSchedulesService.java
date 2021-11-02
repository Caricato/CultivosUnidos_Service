package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.GetSchedulesUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.GetSchedulesPort;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.time.LocalDate;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetSchedulesService implements GetSchedulesUseCase {
    private final GetSchedulesPort getSchedulesPort;

    @Override
    public List<Schedule> getSchedules(Long communityId, Integer year, Integer active) {
        var yearDate = LocalDate.of(year, 1, 1);
        var nextYear = LocalDate.of(year, 12, 31);
        if (active == 0) return getSchedulesPort.getFinishedSchedules(communityId, yearDate, nextYear);
        return getSchedulesPort.getActiveSchedules(communityId, yearDate, nextYear);
    }
}
