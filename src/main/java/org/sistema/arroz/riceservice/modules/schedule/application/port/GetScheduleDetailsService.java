package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.GetScheduleDetailsUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.GetScheduleDetailsPort;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetScheduleDetailsService implements GetScheduleDetailsUseCase {
    private final GetScheduleDetailsPort getScheduleDetailsPort;

    @Override
    public List<ScheduleDetail> getScheduleDetails(Long scheduleId) {
        return getScheduleDetailsPort.getScheduleDetails(scheduleId);
    }
}
