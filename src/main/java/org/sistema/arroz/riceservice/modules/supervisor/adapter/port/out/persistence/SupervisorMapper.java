package org.sistema.arroz.riceservice.modules.supervisor.adapter.port.out.persistence;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.SupervisorToRegister;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;
import org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence.UserMapper;

@Mapper(componentModel = "spring",  uses = {UserMapper.class})
public interface SupervisorMapper {
    @Mapping(source = "supervisorId", target = "supervisorId")
    @Mapping(source = "supervisorName", target = "supervisorName")
    @Mapping(source = "supervisorFirstLastName", target = "supervisorFirstLastName")
    @Mapping(source = "supervisorSecondLastName", target = "supervisorSecondLastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "dni", target = "dni")
    @Mapping(source = "user", target = "user")
    Supervisor toSupervisor(SupervisorJpaEntity supervisorJpaEntity);

    @InheritInverseConfiguration
    SupervisorJpaEntity toSupervisorJpa(Supervisor supervisor);

    @Mapping(source = "supervisorName", target = "supervisorName")
    @Mapping(source = "supervisorFirstLastName", target = "supervisorFirstLastName")
    @Mapping(source = "supervisorSecondLastName", target = "supervisorSecondLastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "dni", target = "dni")
    @Mapping(target = "supervisorId", ignore = true)
    @Mapping(target = "user", ignore = true)
    SupervisorJpaEntity toSupervisorJpa(SupervisorToRegister supervisorToRegister);
}
