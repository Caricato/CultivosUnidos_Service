package org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence;

import org.mapstruct.Mapper;
import org.sistema.arroz.riceservice.modules.users.domain.UserRole;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {
    default UserRole toUserRole(String value){
        switch(value){
            case "SUPERVISOR": return UserRole.SUPERVISOR;
            case "PRODUCTOR AGRICOLA": return UserRole.PRODUCER;
            default: return null;
        }
    }
}
