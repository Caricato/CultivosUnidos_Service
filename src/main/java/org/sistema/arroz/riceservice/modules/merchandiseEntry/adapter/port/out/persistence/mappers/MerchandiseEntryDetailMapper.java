package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseFlowDetailJpaEntity;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.MerchandiseEntryDetailToPersist;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.MerchandiseProductDetailToPersist;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowProductDetail;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.ProductMapper;
import org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence.SupplyMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MerchandiseFlowMapper.class, SupplyMapper.class, ProductMapper.class})
public interface MerchandiseEntryDetailMapper {
    @Mapping(source = "flowDetailId", target = "entryDetailId")
    @Mapping(source = "merchandiseFlow", target = "merchandiseFlow")
    @Mapping(source = "supply", target = "supply")
    @Mapping(source = "flowCant", target = "entryCant")
    MerchandiseFlowDetail toMerchandiseEntryDetail(MerchandiseFlowDetailJpaEntity merchandiseFlowDetailJpaEntity);
    List<MerchandiseFlowDetail> toMerchandiseEntriesDetail(List<MerchandiseFlowDetailJpaEntity> merchandiseEntryDetailJpaEntities);

    @Mapping(source = "flowDetailId", target = "entryDetailId")
    @Mapping(source = "merchandiseFlow", target = "merchandiseFlow")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "flowCant", target = "entryCant")
    MerchandiseFlowProductDetail toMerchandiseFlowProductDetail(MerchandiseFlowDetailJpaEntity merchandiseFlowDetailJpaEntity);
    List<MerchandiseFlowProductDetail> toMerchandiseFlowProductsDetail(List<MerchandiseFlowDetailJpaEntity> merchandiseFlowDetailJpaEntity);


    @Mapping(source = "entryCant", target = "flowCant")
    @Mapping(target = "flowDetailId", ignore = true)
    @Mapping(source = "supply", target = "supply")
    @Mapping(target="product", ignore = true)
    @Mapping(source="merchandiseFlow", target = "merchandiseFlow")
    MerchandiseFlowDetailJpaEntity toMerchandiseFlowDetailJpa(MerchandiseEntryDetailToPersist detailToPersist);
    List<MerchandiseFlowDetailJpaEntity> toMerchandiseEntriesDetailJpa(List<MerchandiseEntryDetailToPersist> detailsToRegister);

    @Mapping(source = "entryCant", target = "flowCant")
    @Mapping(target = "flowDetailId", ignore = true)
    @Mapping(source = "product", target = "product")
    @Mapping(target="supply", ignore = true)
    @Mapping(source="merchandiseFlow", target = "merchandiseFlow")
    MerchandiseFlowDetailJpaEntity toMerchandiseProductDetailJpa(MerchandiseProductDetailToPersist detailToPersist);
    List<MerchandiseFlowDetailJpaEntity> toMerchandiseProductsDetailJpa(List<MerchandiseProductDetailToPersist> detailToPersist);
}
