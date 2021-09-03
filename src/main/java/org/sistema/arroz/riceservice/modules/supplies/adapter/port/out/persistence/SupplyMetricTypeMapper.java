package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import org.mapstruct.Mapper;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;

@Mapper(componentModel = "spring")
public interface SupplyMetricTypeMapper {
    default SupplyMetricType toSupplyMetricType(Integer value){
        switch (value){
            case 0:
                return SupplyMetricType.UNIDADES;
            case 1:
                return SupplyMetricType.KILOGRAMOS;
            case 2:
                return SupplyMetricType.GRAMOS;
            case 3:
                return SupplyMetricType.LITROS;
            default:
                return null;
        }
    }
}