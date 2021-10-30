package org.sistema.arroz.riceservice.modules.parameters.adapter.port.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.parameters.domain.Parameters;

@Mapper(componentModel = "spring")
public interface ParametersMapper {
    @Mapping(source = "durationSchedule", target = "durationSchedule")
    Parameters toParameters(ParametersJpaEntity parametersJpaEntity);
}
