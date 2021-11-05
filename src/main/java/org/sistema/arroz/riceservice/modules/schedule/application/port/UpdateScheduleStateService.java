package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.notifications.application.port.in.SendSMSToFinishScheduleUseCase;
import org.sistema.arroz.riceservice.modules.notifications.application.port.in.SendSMSToStartScheduleUseCase;
import org.sistema.arroz.riceservice.modules.notifications.domain.SendSMSException;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.FinishScheduleUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.GetScheduleDetailsUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.UpdateScheduleStateUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.UpdateScheduleStatePort;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class UpdateScheduleStateService implements UpdateScheduleStateUseCase {
    private final UpdateScheduleStatePort updateScheduleStatePort;
    private final GetScheduleDetailsUseCase getScheduleDetailsUseCase;
    private final SendSMSToStartScheduleUseCase sendSMSToStartScheduleUseCase;
    private final SendSMSToFinishScheduleUseCase sendSMSToFinishScheduleUseCase;
    private final FinishScheduleUseCase finishScheduleUseCase;

    @Override
    public List<Schedule> updateScheduleState() {
        var schedulesActivated = updateScheduleStatePort.activateSchedules();
        var schedulesFinished = updateScheduleStatePort.finishSchedules();

        schedulesFinished.forEach(schedule -> finishScheduleUseCase.finishSchedule(schedule.getScheduleId()));
        var schedulesUpdated = new ArrayList<Schedule>();
        try{
            sendNotificationsToStart(schedulesActivated);
        }catch(Exception ex){
            throw new SendSMSException(ex.getMessage());
        }
        schedulesUpdated.addAll(schedulesActivated);
        schedulesUpdated.addAll(schedulesFinished);
        return schedulesUpdated;
    }

    private void sendNotificationsToStart(List<Schedule> schedules){
        for(var schedule: schedules){
            var scheduleDetails = getScheduleDetailsUseCase.getScheduleDetails(schedule.getScheduleId());
            sendSMSToStartScheduleUseCase.sendSMSToPend(schedule, scheduleDetails);
        }
    }
}
