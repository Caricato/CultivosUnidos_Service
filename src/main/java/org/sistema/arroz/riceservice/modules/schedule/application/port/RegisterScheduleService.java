package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.LocalDateTimePeruZone;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.RegisterSupplyOutUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowSubtype;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowType;
import org.sistema.arroz.riceservice.modules.notifications.application.port.in.SendSMSToPendScheduleUseCase;
import org.sistema.arroz.riceservice.modules.notifications.domain.SendSMSException;
import org.sistema.arroz.riceservice.modules.parameters.application.port.in.GetScheduleDurationUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.RegisterScheduleUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ScheduleToRegister;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ValidateHectaresUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ValidateStockUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.DeleteSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.RegisterScheduleDetailsPort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.RegisterSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.ScheduleDetailToRegister;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDateException;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleHectaresNotValidException;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleType;

import java.time.LocalDate;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterScheduleService implements RegisterScheduleUseCase {
    private final ValidateHectaresUseCase validateHectaresUseCase;
    private final ValidateStockUseCase validateStockUseCase;
    private final GetProductUseCase getProductUseCase;
    private final RegisterSchedulePort registerSchedulePort;
    private final RegisterScheduleDetailsPort registerScheduleDetailsPort;
    private final DeleteSchedulePort deleteSchedulePort;
    private final GetScheduleDurationUseCase getScheduleDurationUseCase;
    private final RegisterSupplyOutUseCase registerSupplyOutUseCase;
    private final SendSMSToPendScheduleUseCase sendSMSToPendScheduleUseCase;

    @Override
    public Schedule registerSchedule(Long communityId, ScheduleToRegister scheduleToRegister) {
        var startDate = scheduleToRegister.getStartDate();
        if (startDate.compareTo(LocalDateTimePeruZone.now().toLocalDate()) < 0){
            throw new ScheduleDateException(startDate);
        }
        if (scheduleToRegister.getHectares() <= 0 ||(scheduleToRegister.getCantProducers() != null && scheduleToRegister.getCantProducers() <=0))
            throw new ScheduleHectaresNotValidException(scheduleToRegister.getHectares(), scheduleToRegister.getCantProducers());
        var merchandiseOut = validateStockUseCase.validateStockSchedule(communityId, scheduleToRegister);
        if(startDate.compareTo(LocalDateTimePeruZone.now().toLocalDate()) > 0)
            scheduleToRegister.setScheduleType(ScheduleType.PENDING);
        else scheduleToRegister.setScheduleType(ScheduleType.IN_PROCESS);

        var schedule =  registerScheduleDetails(communityId, scheduleToRegister);
        registerSupplyOutUseCase.registerSupplyOut(MerchandiseEntryToRegister.builder()
                .entryType(MerchandiseFlowType.CRONOGRAMA)
                .entryDate(LocalDateTimePeruZone.now()).subtype(MerchandiseFlowSubtype.SALIDA_INSUMO)
                .build(),merchandiseOut, communityId);
        return schedule;
    }

    private LocalDate calculateEndDate(Long communityId, LocalDate initialDate){
        var monthsOffset = getScheduleDurationUseCase.getScheduleDuration(communityId);
        return initialDate.plusMonths(monthsOffset);
    }

    private Schedule registerScheduleDetails(Long communityId, ScheduleToRegister scheduleToRegister){
        var scheduleDetails = validateHectaresUseCase.validateHectares(communityId, scheduleToRegister);
        scheduleToRegister.setCantProducers(scheduleDetails.size());
        scheduleToRegister.setEndDate(calculateEndDate(communityId, scheduleToRegister.getStartDate()));
        var schedule = registerSchedulePort.registerSchedule(scheduleToRegister, getProductUseCase.getProductById(scheduleToRegister.getProductId()));
        try{
            registerScheduleDetailsPort.registerScheduleDetails(scheduleDetails, schedule);
        }catch (Exception ex){
            deleteSchedulePort.deleteSchedule(schedule.getScheduleId());
            throw ex;
        }
        sendNotificationsToProducers(schedule, scheduleDetails);
        return schedule;
    }

    private void sendNotificationsToProducers(Schedule schedule, List<ScheduleDetailToRegister> scheduleDetails){
        try{
            sendSMSToPendScheduleUseCase.sendSMSToPend(schedule, scheduleDetails);
        }catch(Exception ex){
            throw new SendSMSException(ex.getMessage());
        }
    }
}
