package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetSuppliesDTOMapper {
    @Mapping(source = "supplyId", target = "supplyId")
    @Mapping(source = "supplyMetricType.name",target = "supplyMetricType")
    @Mapping(source = "unitPricing",target = "unitPricing")
    @Mapping(source = "stockMin", target = "stockMin")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "supplyName", target = "supplyName")
    GetSuppliesDTO toSupplyDTO(Supply supply);
    List<GetSuppliesDTO> toSuppliesDTO(List<Supply> supplyList);
}
