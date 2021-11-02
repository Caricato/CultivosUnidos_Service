package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetScheduleDetailDTOMapper {
    @Mapping(source = "scheduleDetailId", target = "scheduleDetailId")
    @Mapping(source = "isFreeHectares", target = "isFreeHectares")
    @Mapping(source = "producer.dni", target = "producerDNI")
    @Mapping(source = "hectares", target = "producerHectares")
    @Mapping(target = "producerName", ignore = true)
    GetScheduleDetailDTO toScheduleDetailDTO(ScheduleDetail scheduleDetail);
    List<GetScheduleDetailDTO> toScheduleDetailsDTO(List<ScheduleDetail> scheduleDetails);

    @AfterMapping
    default void setScheduleDetailProducerName(ScheduleDetail scheduleDetail, @MappingTarget GetScheduleDetailDTO getScheduleDetailDTO){
        getScheduleDetailDTO.setProducerName(scheduleDetail.getProducer().fullName());
    }
}
