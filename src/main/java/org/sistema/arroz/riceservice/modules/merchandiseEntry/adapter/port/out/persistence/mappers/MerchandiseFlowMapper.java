package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseFlowJpaEntity;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;

import java.util.List;

@Mapper(componentModel = "spring", uses = { AgricultureCommunityMapper.class, MerchandiseEntryTypeMapper.class})
public interface MerchandiseFlowMapper {
    @Mapping(source = "merchandiseFlowId", target = "merchandiseEntryId")
    @Mapping(source = "entryDate", target = "entryDate")
    @Mapping(source = "flowType", target = "entryType")
    @Mapping(source = "community", target = "community")
    MerchandiseEntry toMerchandiseEntry(MerchandiseFlowJpaEntity entryJpaEntity);
    List<MerchandiseEntry> toMerchandiseEntries(List<MerchandiseFlowJpaEntity> entryJpaEntities);

    @InheritInverseConfiguration
    @Mapping(source = "entryType.value", target = "flowType")
    MerchandiseFlowJpaEntity toMerchandiseEntryJpa(MerchandiseEntry merchandiseEntry);

    @Mapping(source = "entryDate", target = "entryDate")
    @Mapping(source = "entryType.value", target = "flowType")
    @Mapping(target = "community", ignore = true)
    @Mapping(target = "merchandiseFlowId", ignore = true)
    MerchandiseFlowJpaEntity toMerchandiseEntryJpa(MerchandiseEntryToRegister entryToRegister);
}
