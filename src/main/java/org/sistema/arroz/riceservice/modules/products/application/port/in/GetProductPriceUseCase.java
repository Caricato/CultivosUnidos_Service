package org.sistema.arroz.riceservice.modules.products.application.port.in;

import org.sistema.arroz.riceservice.modules.products.domain.ProductPrice;

public interface GetProductPriceUseCase {
    ProductPrice getProductPrice(Long productId, Integer month);
}
