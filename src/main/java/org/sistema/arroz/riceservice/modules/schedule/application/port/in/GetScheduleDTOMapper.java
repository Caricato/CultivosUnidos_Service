package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleType;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetScheduleDTOMapper {
    @Mapping(source = "scheduleId", target = "scheduleId")
    @Mapping(source = "hectares", target = "hectares")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "product.productName", target = "productName")
    GetScheduleDTO getScheduleDTO(Schedule schedule);
    List<GetScheduleDTO> getSchedulesDTO(List<Schedule> schedules);

    @AfterMapping
    default void setState(Schedule schedule, @MappingTarget GetScheduleDTO getScheduleDTO){
        if (schedule.getState().equals(ScheduleType.PENDING)){
            getScheduleDTO.setState("PENDIENTE");
        }
        else if (schedule.getState().equals(ScheduleType.IN_PROCESS)){
            getScheduleDTO.setState("EN PROCESO");
        }
        else if(schedule.getState().equals(ScheduleType.FINALIZED)){
            getScheduleDTO.setState("FINALIZADO");
        }
        else getScheduleDTO.setState("CANCELADO");
    }
}
