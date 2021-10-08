package org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.users.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "passwordReset", target = "passwordReset")
    @Mapping(source = "passwordFirstTime", target = "passwordFirstTime")
    @Mapping(source = "state", target = "state")
    User toUser(UserJpaEntity userJpaEntity);
}
