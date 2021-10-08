package org.sistema.arroz.riceservice.modules.producers.adapter.port.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToRegister;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence.UserMapper;

@Mapper(componentModel = "spring", uses = {AgricultureCommunityMapper.class, UserMapper.class})
public interface ProducerMapper {
    @Mapping(source = "community", target = "community")
    @Mapping(source = "inscriptionDate", target = "inscriptionDate")
    @Mapping(source = "producerSecondLastName", target = "producerSecondLastName")
    @Mapping(source = "producerId", target = "producerId")
    @Mapping(source = "producerName", target = "producerName")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "producerFirstLastName", target = "producerFirstLastName")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "updateDate", target = "updateDate")
    @Mapping(source = "hectares", target = "hectares")
    Producer toProducer(ProducerJpaEntity producerJpaEntity);

    @Mapping(source = "hectares", target = "hectares")
    @Mapping(source = "producerName", target = "producerName")
    @Mapping(source = "producerFirstLastName", target = "producerFirstLastName")
    @Mapping(source = "producerSecondLastName", target = "producerSecondLastName")
    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "email", target = "email")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "community", ignore = true)
    @Mapping(target = "inscriptionDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    ProducerJpaEntity toProducerJpa(ProducerToRegister producerToRegister);
}
