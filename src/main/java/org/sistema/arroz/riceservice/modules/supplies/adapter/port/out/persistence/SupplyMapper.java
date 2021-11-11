package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToRegister;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UnitMetricMapper.class, AgricultureCommunityMapper.class})
public interface SupplyMapper {
    @Mapping(source = "supplyId", target = "supplyId")
    @Mapping(source = "supplyName", target = "supplyName")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "unitPricing", target = "unitPricing")
    @Mapping(source = "stockMin", target = "stockMin")
    @Mapping(source = "unitMetric", target = "supplyMetricType")
    @Mapping(source = "state", target = "state")
    @Mapping(source = "communityJpaEntity", target = "community")
    Supply toSupply(SupplyJpaEntity supplyJpaEntity);
    List<Supply> toSupplies(List<SupplyJpaEntity> supplyJpaEntities);

    @InheritInverseConfiguration
    SupplyJpaEntity toSupplyJpaEntity(Supply supply);

    @Mapping(source = "supplyName", target = "supplyName")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "unitPricing", target = "unitPricing")
    @Mapping(source = "stockMin", target = "stockMin")
    @Mapping(target = "supplyId", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "communityJpaEntity", ignore = true)
    @Mapping(target = "unitMetric", ignore = true)
    SupplyJpaEntity toSupplyJpaEntity(SupplyToRegister supplyToRegister);
}