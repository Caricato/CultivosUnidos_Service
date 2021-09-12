package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence.SupplyMetricTypeMapper;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SupplyMetricTypeMapper.class})
public interface GetAllSuppliesForEntriesMapper {
    @Mapping(source = "supplyId", target = "supplyId")
    @Mapping(source = "supplyName", target = "supplyName")
    @Mapping(source = "supplyMetricType", target = "supplyMetricType")
    List<GetAllSuppliesForEntriesDTO> toGetAllSuppliesForEntries(List<Supply> supply);
}
