package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence;

import org.mapstruct.Mapper;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleType;

@Mapper(componentModel = "spring")
public interface ScheduleTypeMapper {
    default ScheduleType toScheduleType(Integer value){
        switch(value){
            case 0:
                return ScheduleType.PENDING;
            case 1:
                return ScheduleType.IN_PROCESS;
            case 2:
                return ScheduleType.FINALIZED;
            case 3:
                return ScheduleType.CANCELLED;
            default:
                return null;
        }
    }
}
