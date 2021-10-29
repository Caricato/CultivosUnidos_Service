package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.mappers;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.entities.ProductJpaEntity;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

import java.util.List;

@Mapper(componentModel = "spring", uses = { AgricultureCommunityMapper.class})
public interface ProductMapper {
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "sacks", target = "sacks")
    @Mapping(source = "relationSacks", target = "relationSacks")
    @Mapping(source = "communityJpaEntity", target = "community")
    @Mapping(source = "state", target = "state")
    Product toProduct (ProductJpaEntity productJpaEntity);
    List<Product> toProducts (List<ProductJpaEntity> productJpaEntity);

    @InheritConfiguration
    ProductJpaEntity toProductJpa(Product product);

    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "stock", target = "sacks")
    @Mapping(source = "sacks", target = "relationSacks")
    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "communityJpaEntity", ignore = true)
    ProductJpaEntity toProductJpaEntity(ProductToRegister productToRegister);
}
