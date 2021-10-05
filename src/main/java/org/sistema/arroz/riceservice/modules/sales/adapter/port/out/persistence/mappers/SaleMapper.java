package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.entities.SaleJpaEntity;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleToRegister;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.SaleToPersist;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AgricultureCommunityMapper.class})
public interface SaleMapper {
    @Mapping(source = "saleId", target = "saleId")
    @Mapping(source = "saleDate", target = "saleDate")
    @Mapping(source = "saleTotal", target = "saleTotal")
    @Mapping(source = "theoreticalTotal", target = "theoreticalTotal")
    @Mapping(source = "community", target = "community")
    Sale toSale(SaleJpaEntity saleJpaEntity);
    List<Sale> toSales(List<SaleJpaEntity> saleJpaEntity);

    @Mapping(source = "community", target = "community")
    @Mapping(source = "saleDate", target = "saleDate")
    @Mapping(source = "saleTotal", target = "saleTotal")
    @Mapping(source = "theoreticalTotal", target = "theoreticalTotal")
    @Mapping(target = "saleId", ignore = true)
    SaleJpaEntity toSaleJpa(SaleToPersist saleToPersist);
}
