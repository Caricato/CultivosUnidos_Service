package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.mappers.ProductMapper;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.entities.ScheduleJpaEntity;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ScheduleToRegister;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, ScheduleTypeMapper.class})
public interface ScheduleMapper {
    @Mapping(source = "scheduleId", target = "scheduleId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "hectares", target = "hectares")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "state", target = "state")
    Schedule toSchedule(ScheduleJpaEntity scheduleJpaEntity);
    List<Schedule> toSchedules(List<ScheduleJpaEntity> scheduleJpaEntityList);

    @InheritInverseConfiguration
    @Mapping(source = "state.value", target = "state")
    ScheduleJpaEntity toScheduleJpa(Schedule schedule);

    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "hectares", target = "hectares")
    @Mapping(source = "scheduleType.value", target = "state")
    @Mapping(target = "scheduleId", ignore = true)
    @Mapping(target = "product", ignore = true)
    ScheduleJpaEntity toScheduleJpa(ScheduleToRegister scheduleToRegister);
}
