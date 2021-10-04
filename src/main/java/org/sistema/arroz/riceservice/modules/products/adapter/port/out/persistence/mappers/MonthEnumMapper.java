package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.mappers;

import org.mapstruct.Mapper;
import org.sistema.arroz.riceservice.modules.products.domain.MonthEnum;

@Mapper(componentModel = "spring")
public interface MonthEnumMapper {
    default MonthEnum toMonth(Integer value){
        switch(value){
            case 1: return MonthEnum.ENERO;
            case 2: return MonthEnum.FEBRERO;
            case 3: return MonthEnum.MARZO;
            case 4: return MonthEnum.ABRIL;
            case 5: return MonthEnum.MAYO;
            case 6: return MonthEnum.JUNIO;
            case 7: return MonthEnum.JULIO;
            case 8: return MonthEnum.AGOSTO;
            case 9: return MonthEnum.SETIEMBRE;
            case 10: return MonthEnum.OCTUBRE;
            case 11: return MonthEnum.NOVIEMBRE;
            case 12: return MonthEnum.DICIEMBRE;
            default: return null;
        }
    }
}
