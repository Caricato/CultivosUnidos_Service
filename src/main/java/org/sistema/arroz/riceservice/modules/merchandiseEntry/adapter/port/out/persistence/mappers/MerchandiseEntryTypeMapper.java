package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers;

import org.mapstruct.Mapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowType;

@Mapper(componentModel = "spring")
public interface MerchandiseEntryTypeMapper {
    default MerchandiseFlowType toMerchandiseEntryType(Integer value){
        switch(value){
            case 0:
                return MerchandiseFlowType.COMPRA;
            case 1:
                return MerchandiseFlowType.ASOCIACION;
            default:
                return null;
        }
    }
}
