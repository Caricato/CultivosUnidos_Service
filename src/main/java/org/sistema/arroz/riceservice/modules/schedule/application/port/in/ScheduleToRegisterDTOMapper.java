package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleToRegisterDTOMapper {
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "cantProducers", target = "cantProducers")
    @Mapping(source = "hectares", target = "hectares")
    @Mapping(source = "productId", target = "productId")
    ScheduleToRegister toScheduleToRegister(ScheduleToRegisterDTO scheduleToRegisterDTO);
}
