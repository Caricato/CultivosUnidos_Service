package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.GetSchedulesUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.GetSchedulesPort;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetSchedulesService implements GetSchedulesUseCase {
    private final GetSchedulesPort getSchedulesPort;

    @Override
    public List<Schedule> getSchedules(Long communityId) {
        return getSchedulesPort.getSchedules(communityId);
    }
}
