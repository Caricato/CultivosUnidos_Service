package org.sistema.arroz.riceservice.modules.products.application.port.out;

import org.sistema.arroz.riceservice.modules.products.domain.ProductPrice;

import java.util.List;

public interface GetProductPricesPort {
    List<ProductPrice> getProductPrices(Long productId);
}
