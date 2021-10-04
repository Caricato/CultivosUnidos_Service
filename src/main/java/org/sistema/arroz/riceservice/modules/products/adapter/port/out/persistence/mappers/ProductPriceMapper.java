package org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.entities.ProductPriceJpaEntity;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductPriceToRegister;
import org.sistema.arroz.riceservice.modules.products.domain.ProductPrice;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ProductMapper.class, MonthEnumMapper.class})
public interface ProductPriceMapper {
    @Mapping(source = "productPriceId", target = "productPriceId")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "unitPricing", target = "unitPricing")
    @Mapping(source = "month", target = "month")
    ProductPrice toProductPrice(ProductPriceJpaEntity productPriceJpaEntity);
    List<ProductPrice> toProductPrices(List<ProductPriceJpaEntity> productPriceJpaEntities);

    @Mapping(source = "month.value", target = "month")
    @Mapping(source = "unitPricing", target = "unitPricing")
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "productPriceId", ignore = true)
    ProductPriceJpaEntity toProductPriceJpa(ProductPriceToRegister productPriceToRegister);
    List<ProductPriceJpaEntity> toProductPricesJpa(List<ProductPriceToRegister> productPricesToRegister);
}
