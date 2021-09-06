package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseEntryDetailJpaEntity;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.MerchandiseEntryDetailToPersist;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryDetail;
import org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence.SupplyMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MerchandiseEntryMapper.class, SupplyMapper.class})
public interface MerchandiseEntryDetailMapper {
    @Mapping(source = "entryDetailId", target = "entryDetailId")
    @Mapping(source = "merchandiseEntry", target = "merchandiseEntry")
    @Mapping(source = "supply", target = "supply")
    @Mapping(source = "entryCant", target = "entryCant")
    MerchandiseEntryDetail toMerchandiseEntryDetail(MerchandiseEntryDetailJpaEntity merchandiseEntryDetailJpaEntity);
    List<MerchandiseEntryDetail> toMerchandiseEntriesDetail(List<MerchandiseEntryDetailJpaEntity> merchandiseEntryDetailJpaEntities);

    @Mapping(source = "entryCant", target = "entryCant")
    @Mapping(target = "entryDetailId", ignore = true)
    @Mapping(source = "supply", target = "supply")
    @Mapping(source = "merchandiseEntry", target = "merchandiseEntry")
    List<MerchandiseEntryDetailJpaEntity> toMerchandiseEntriesDetailJpa(List<MerchandiseEntryDetailToPersist> detailsToRegister);
}
