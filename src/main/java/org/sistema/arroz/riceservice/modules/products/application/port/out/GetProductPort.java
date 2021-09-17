package org.sistema.arroz.riceservice.modules.products.application.port.out;

import org.sistema.arroz.riceservice.modules.products.domain.Product;

import java.util.Optional;

public interface GetProductPort {
    Optional<Product> getProductById(Long productId);
}
