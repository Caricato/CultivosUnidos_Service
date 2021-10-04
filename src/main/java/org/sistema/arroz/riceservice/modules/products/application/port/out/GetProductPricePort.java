package org.sistema.arroz.riceservice.modules.products.application.port.out;

import org.sistema.arroz.riceservice.modules.products.domain.ProductPrice;

public interface GetProductPricePort {
    ProductPrice getProductPrice(Long productId, Integer month);
}
