package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

@Mapper(componentModel = "spring", uses = { AgricultureCommunityMapper.class})
public interface ProductMapper {
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "communityJpaEntity", target = "community")
    @Mapping(source = "state", target = "state")
    Product toProduct (ProductJpaEntity productJpaEntity);

    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "sacks", target = "sacks")
    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "communityJpaEntity", ignore = true)
    ProductJpaEntity toProductJpaEntity(ProductToRegister productToRegister);
}
