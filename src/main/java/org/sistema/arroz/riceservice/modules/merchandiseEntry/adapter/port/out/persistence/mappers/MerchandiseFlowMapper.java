package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseFlowJpaEntity;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;

import java.util.List;

@Mapper(componentModel = "spring", uses = { AgricultureCommunityMapper.class, MerchandiseEntryTypeMapper.class, MerchandiseFlowSubtypeMapper.class})
public interface MerchandiseFlowMapper {
    @Mapping(source = "merchandiseFlowId", target = "merchandiseEntryId")
    @Mapping(source = "entryDate", target = "entryDate")
    @Mapping(source = "flowType", target = "entryType")
    @Mapping(source = "subtype", target = "subtype")
    @Mapping(source = "community", target = "community")
    MerchandiseFlow toMerchandiseEntry(MerchandiseFlowJpaEntity entryJpaEntity);
    List<MerchandiseFlow> toMerchandiseEntries(List<MerchandiseFlowJpaEntity> entryJpaEntities);

    @InheritInverseConfiguration
    @Mapping(source = "entryType.value", target = "flowType")
    @Mapping(source = "subtype.value", target = "subtype")
    MerchandiseFlowJpaEntity toMerchandiseEntryJpa(MerchandiseFlow merchandiseFlow);

    @Mapping(source = "entryDate", target = "entryDate")
    @Mapping(source = "entryType.value", target = "flowType")
    @Mapping(source = "subtype.value", target = "subtype")
    @Mapping(target = "community", ignore = true)
    @Mapping(target = "merchandiseFlowId", ignore = true)
    MerchandiseFlowJpaEntity toMerchandiseEntryJpa(MerchandiseEntryToRegister entryToRegister);
}
