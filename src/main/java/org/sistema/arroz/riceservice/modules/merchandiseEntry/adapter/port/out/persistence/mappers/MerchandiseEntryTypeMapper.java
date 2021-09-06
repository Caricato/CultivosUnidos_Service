package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers;

import org.mapstruct.Mapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryType;

@Mapper(componentModel = "spring")
public interface MerchandiseEntryTypeMapper {
    default MerchandiseEntryType toMerchandiseEntryType(Integer value){
        switch(value){
            case 0:
                return MerchandiseEntryType.COMPRA;
            case 1:
                return MerchandiseEntryType.ASOCIACION;
            default:
                return null;
        }
    }
}
