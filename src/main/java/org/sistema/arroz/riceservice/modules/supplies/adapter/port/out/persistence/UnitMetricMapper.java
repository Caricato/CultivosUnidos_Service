package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.UnitMetricToRegister;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AgricultureCommunityMapper.class})
public interface UnitMetricMapper {
    @Mapping(source = "state", target = "state")
    @Mapping(source = "community", target = "community")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "unitMetricId", target = "unitMetricId")
    UnitMetric toUnitMetric(UnitMetricJpaEntity unitMetricJpaEntity);
    List<UnitMetric> toUnitMetrics(List<UnitMetricJpaEntity> unitMetricJpaEntities);

    @InheritConfiguration
    UnitMetricJpaEntity toUnitMetricJpa(UnitMetricJpaEntity unitMetricJpaEntity);

    @Mapping(source = "name", target = "name")
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "community", ignore = true)
    @Mapping(target = "unitMetricId", ignore = true)
    UnitMetricJpaEntity toUnitMetricJpa(UnitMetricToRegister unitMetricToRegister);
}
