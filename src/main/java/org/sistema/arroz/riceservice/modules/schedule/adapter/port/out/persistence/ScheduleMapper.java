package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.mappers.ProductMapper;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ScheduleMapper {
    @Mapping(source = "scheduleId", target = "scheduleId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "hectares", target = "hectares")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "state", target = "state")
    Schedule toSchedule(ScheduleJpaEntity scheduleJpaEntity);
}
