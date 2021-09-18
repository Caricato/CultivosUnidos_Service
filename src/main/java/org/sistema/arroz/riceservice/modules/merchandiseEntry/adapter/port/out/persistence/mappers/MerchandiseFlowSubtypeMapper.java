package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers;

import org.mapstruct.Mapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowSubtype;
@Mapper(componentModel = "spring")
public interface MerchandiseFlowSubtypeMapper {
    default MerchandiseFlowSubtype toMerchandiseFlowSubtype(Integer value){
        switch(value){
            case 0:
                return MerchandiseFlowSubtype.ENTRADA_INSUMO;
            case 1:
                return MerchandiseFlowSubtype.SALIDA_INSUMO;
            case 2:
                return MerchandiseFlowSubtype.ENTRADA_PRODUCTO;
            default:
                return null;
        }
    }
}
