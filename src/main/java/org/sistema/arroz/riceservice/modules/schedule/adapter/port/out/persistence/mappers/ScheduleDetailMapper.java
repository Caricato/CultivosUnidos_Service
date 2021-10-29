package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.mappers;

import org.mapstruct.*;
import org.sistema.arroz.riceservice.modules.producers.adapter.port.out.persistence.ProducerMapper;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.entities.ScheduleDetailJpaEntity;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.entities.ScheduleJpaEntity;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.ScheduleDetailToRegister;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;

import java.util.List;

@Mapper(componentModel = "spring", uses ={ScheduleMapper.class, ProducerMapper.class})
public interface ScheduleDetailMapper {
    @Mapping(source = "scheduleDetailId", target = "scheduleDetailId")
    @Mapping(source = "hectares", target = "hectares")
    @Mapping(source = "isFreeHectares", target = "isFreeHectares")
    @Mapping(source = "schedule", target = "schedule")
    @Mapping(source = "producer", target = "producer")
    ScheduleDetail toScheduleDetail(ScheduleDetailJpaEntity scheduleDetailJpaEntity);
    List<ScheduleDetail> toScheduleDetails(List<ScheduleDetailJpaEntity> scheduleDetailJpaEntity);

    @Mapping(source = "hectares", target = "hectares")
    @Mapping(source = "isFreeHectares", target = "isFreeHectares")
    @Mapping(source = "scheduleDetailToRegister.producer", target = "producer")
    @Mapping(target = "scheduleDetailId", ignore = true)
    @Mapping(target = "schedule", ignore = true)
    ScheduleDetailJpaEntity toScheduleDetailJpa(ScheduleDetailToRegister scheduleDetailToRegister);
    List<ScheduleDetailJpaEntity> toScheduleDetailsJpa(List<ScheduleDetailToRegister> scheduleDetailsToRegister);
}
