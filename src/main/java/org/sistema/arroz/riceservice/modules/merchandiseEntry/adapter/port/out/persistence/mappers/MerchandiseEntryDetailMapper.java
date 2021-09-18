package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseFlowDetailJpaEntity;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.MerchandiseEntryDetailToPersist;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryDetail;
import org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence.SupplyMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MerchandiseFlowMapper.class, SupplyMapper.class})
public interface MerchandiseEntryDetailMapper {
    @Mapping(source = "flowDetailId", target = "entryDetailId")
    @Mapping(source = "flowEntry", target = "merchandiseEntry")
    @Mapping(source = "supply", target = "supply")
    @Mapping(source = "flowCant", target = "entryCant")
    MerchandiseEntryDetail toMerchandiseEntryDetail(MerchandiseFlowDetailJpaEntity merchandiseFlowDetailJpaEntity);
    List<MerchandiseEntryDetail> toMerchandiseEntriesDetail(List<MerchandiseFlowDetailJpaEntity> merchandiseEntryDetailJpaEntities);

    @Mapping(source = "entryCant", target = "flowCant")
    @Mapping(target = "flowDetailId", ignore = true)
    @Mapping(source = "supply", target = "supply")
    @Mapping(source = "merchandiseEntry", target = "flowEntry")
    List<MerchandiseFlowDetailJpaEntity> toMerchandiseEntriesDetailJpa(List<MerchandiseEntryDetailToPersist> detailsToRegister);
}
