package org.sistema.arroz.riceservice.modules.products.application.port.in;

import org.sistema.arroz.riceservice.modules.products.domain.Product;

public interface GetProductUseCase {
    Product getProductById(Long productId);
}
