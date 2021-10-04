package org.sistema.arroz.riceservice.modules.sales.application.port.in.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleDetailDTO;
import org.sistema.arroz.riceservice.modules.sales.domain.SaleDetail;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleDetailDTOMapper {
    @Mapping(source = "soldSacks", target = "soldSacks")
    @Mapping(source = "saleDetailId", target = "saleDetailId")
    @Mapping(source = "subtotal", target = "subtotal")
    @Mapping(source = "product.productName", target = "productName")
    SaleDetailDTO toSaleDetailDTO(SaleDetail saleDetail);
    List<SaleDetailDTO> toSaleDetailsDTO(List<SaleDetail> saleDetails);
}
