package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.mappers.ProductMapper;
import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.entities.SaleDetailJpaEntity;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.SaleDetailToPersist;
import org.sistema.arroz.riceservice.modules.sales.domain.SaleDetail;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SaleMapper.class, ProductMapper.class})
public interface SaleDetailMapper {
    @Mapping(source = "saleDetailId", target = "saleDetailId")
    @Mapping(source = "soldSacks", target = "soldSacks")
    @Mapping(source = "subtotal", target = "subtotal")
    @Mapping(source = "sale", target = "sale")
    @Mapping(source = "product", target = "product")
    SaleDetail toSaleDetail(SaleDetailJpaEntity saleDetailJpaEntity);
    List<SaleDetail> toSaleDetails(List<SaleDetailJpaEntity> saleDetailJpaEntity);

    @Mapping(source = "sale", target = "sale")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "soldSacks", target = "soldSacks")
    @Mapping(source = "subtotal", target = "subtotal")
    @Mapping(target = "saleDetailId", ignore = true)
    SaleDetailJpaEntity toSaleDetailJpa(SaleDetailToPersist saleDetailToPersist);
    List<SaleDetailJpaEntity> toSaleDetailsJpa(List<SaleDetailToPersist> saleDetailToPersist);
}
