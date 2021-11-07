package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetUnitMetricDTOMapper {
    @Mapping(source = "unitMetricId", target = "unitMetricId")
    @Mapping(source = "name", target = "name")
    GetUnitMetricDTO toUnitMetricDTO(UnitMetric unitMetric);
    List<GetUnitMetricDTO> toUnitMetricDTOs(List<UnitMetric> unitMetricList);
}
