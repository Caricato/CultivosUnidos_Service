package org.sistema.arroz.riceservice.modules.producers.application.port.in;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetProducerDTOMapper {
    @Mapping(source = "producerId", target = "producerId")
    @Mapping(source = "producerName", target = "producerName")
    @Mapping(source = "producerSecondLastName", target = "producerSecondLastName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "producerFirstLastName", target = "producerFirstLastName")
    @Mapping(source = "hectares", target = "hectares")
    GetProducerDTO toProducerDTO(Producer producer);
    List<GetProducerDTO> toProducersDTO(List<Producer> producers);

    @AfterMapping
    default void setFullName(Producer producer, @MappingTarget GetProducerDTO getProducerDTO){
        getProducerDTO.setFullName(producer.fullName());
    }
}
