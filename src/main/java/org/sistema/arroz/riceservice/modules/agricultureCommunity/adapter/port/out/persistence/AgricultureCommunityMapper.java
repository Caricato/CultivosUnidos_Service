package org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.AgricultureCommunityToRegister;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supervisor.adapter.port.out.persistence.SupervisorMapper;

@Mapper(componentModel = "spring", uses = {SupervisorMapper.class})
public interface AgricultureCommunityMapper {
    @Mapping(source = "communityId", target = "communityId")
    @Mapping(source = "communityName", target = "communityName")
    @Mapping(source = "supervisor", target = "supervisor")
    AgricultureCommunity toAgricultureCommunity(AgricultureCommunityJpaEntity agricultureCommunityJpaEntity);

    @InheritInverseConfiguration
    AgricultureCommunityJpaEntity toAgricultureCommunityJpaEntity(AgricultureCommunity agricultureCommunity);

    @Mapping(source = "communityName", target = "communityName")
    @Mapping(target = "communityId", ignore = true)
    @Mapping(target = "supervisor", ignore = true)
    AgricultureCommunityJpaEntity toAgricultureCommunityJpaEntity(AgricultureCommunityToRegister agricultureCommunityToRegister);
}
