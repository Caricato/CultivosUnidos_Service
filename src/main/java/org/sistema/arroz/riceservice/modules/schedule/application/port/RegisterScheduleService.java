package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.LocalDateTimePeruZone;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.RegisterScheduleUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ScheduleToRegister;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ValidateHectaresUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.DeleteSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.RegisterScheduleDetailsPort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.RegisterSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDateException;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleHectaresNotValidException;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleType;

@UseCase
@RequiredArgsConstructor
public class RegisterScheduleService implements RegisterScheduleUseCase {
    private final ValidateHectaresUseCase validateHectaresUseCase;
    private final GetProductUseCase getProductUseCase;
    private final RegisterSchedulePort registerSchedulePort;
    private final RegisterScheduleDetailsPort registerScheduleDetailsPort;
    private final DeleteSchedulePort deleteSchedulePort;

    @Override
    public Schedule registerSchedule(Long communityId, ScheduleToRegister scheduleToRegister) {
        var startDate = scheduleToRegister.getStartDate();
        if (startDate.compareTo(LocalDateTimePeruZone.now().toLocalDate()) < 0){
            throw new ScheduleDateException(startDate);
        }
        if (scheduleToRegister.getHectares() <= 0 || scheduleToRegister.getCantProducers() <=0) throw new ScheduleHectaresNotValidException(scheduleToRegister.getHectares(), scheduleToRegister.getCantProducers());
        else if(startDate.compareTo(LocalDateTimePeruZone.now().toLocalDate()) > 0) scheduleToRegister.setScheduleType(ScheduleType.PENDING);
        else scheduleToRegister.setScheduleType(ScheduleType.IN_PROCESS);
        var scheduleDetails = validateHectaresUseCase.validateHectares(communityId, scheduleToRegister);
        scheduleToRegister.setCantProducers(scheduleDetails.size());

        var schedule = registerSchedulePort.registerSchedule(scheduleToRegister, getProductUseCase.getProductById(scheduleToRegister.getProductId()));
        try{
            registerScheduleDetailsPort.registerScheduleDetails(scheduleDetails, schedule);
        }catch (Exception ex){
            deleteSchedulePort.deleteSchedule(schedule.getScheduleId());
            throw ex;
        }
        return schedule;
    }
}
