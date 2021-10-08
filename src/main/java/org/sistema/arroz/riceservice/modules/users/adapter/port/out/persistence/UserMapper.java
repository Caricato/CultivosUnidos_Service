package org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.users.application.port.in.UserToRegister;
import org.sistema.arroz.riceservice.modules.users.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "passwordReset", target = "passwordReset")
    @Mapping(source = "passwordFirstTime", target = "passwordFirstTime")
    @Mapping(source = "state", target = "state")
    User toUser(UserJpaEntity userJpaEntity);

    @InheritInverseConfiguration
    UserJpaEntity toUserJpa(User user);

    @Mapping(source = "username", target = "username")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "passwordFirstTime", ignore = true)
    @Mapping(target = "passwordReset", ignore = true)
    @Mapping(target = "state", ignore = true)
    UserJpaEntity toUserJpa(UserToRegister userToRegister);
}
