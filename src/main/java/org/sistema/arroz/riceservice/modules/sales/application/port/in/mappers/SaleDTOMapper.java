package org.sistema.arroz.riceservice.modules.sales.application.port.in.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleDTO;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

@Mapper(componentModel = "spring")
public interface SaleDTOMapper {
    @Mapping(source = "saleId", target = "saleId")
    @Mapping(source = "saleTotal", target = "saleTotal")
    @Mapping(source = "saleDate", target = "saleDate")
    @Mapping(source = "theoreticalTotal", target = "theoreticalTotal")
    SaleDTO toSaleDTO(Sale sale);
}
