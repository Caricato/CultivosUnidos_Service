package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseEntryJpaEntity;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;

import java.util.List;

@Mapper(componentModel = "spring", uses = { AgricultureCommunityMapper.class, MerchandiseEntryTypeMapper.class})
public interface MerchandiseEntryMapper {
    @Mapping(source = "merchandiseEntryId", target = "merchandiseEntryId")
    @Mapping(source = "entryDate", target = "entryDate")
    @Mapping(source = "entryType", target = "entryType")
    @Mapping(source = "community", target = "community")
    MerchandiseEntry toMerchandiseEntry(MerchandiseEntryJpaEntity entryJpaEntity);
    List<MerchandiseEntry> toMerchandiseEntries(List<MerchandiseEntryJpaEntity> entryJpaEntities);

    @InheritInverseConfiguration
    @Mapping(source = "entryType.value", target = "entryType")
    MerchandiseEntryJpaEntity toMerchandiseEntryJpa(MerchandiseEntry merchandiseEntry);

    @Mapping(source = "entryDate", target = "entryDate")
    @Mapping(source = "entryType.value", target = "entryType")
    @Mapping(target = "community", ignore = true)
    @Mapping(target = "merchandiseEntryId", ignore = true)
    MerchandiseEntryJpaEntity toMerchandiseEntryJpa(MerchandiseEntryToRegister entryToRegister);
}
