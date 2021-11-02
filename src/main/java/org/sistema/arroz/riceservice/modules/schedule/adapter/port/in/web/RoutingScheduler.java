package org.sistema.arroz.riceservice.modules.schedule.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.UpdateScheduleStateUseCase;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class RoutingScheduler {
    private final UpdateScheduleStateUseCase updateScheduleStateUseCase;

    @Scheduled(cron = "0 0 0 ? * * *")
    public void generateSchedule(){
        updateScheduleStateUseCase.updateScheduleState();
    }
}
