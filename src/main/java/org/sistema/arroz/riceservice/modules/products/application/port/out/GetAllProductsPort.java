package org.sistema.arroz.riceservice.modules.products.application.port.out;

import org.sistema.arroz.riceservice.modules.products.domain.Product;

import java.util.List;

public interface GetAllProductsPort {
    List<Product> getAllProducts(Long productId);
}
