package org.sistema.arroz.riceservice.modules.products.application.port.in;

import org.sistema.arroz.riceservice.modules.products.domain.ProductPrice;

import java.util.List;

public interface GetProductPricesUseCase {
    List<ProductPrice> getProductPrices(Long productId);
}
