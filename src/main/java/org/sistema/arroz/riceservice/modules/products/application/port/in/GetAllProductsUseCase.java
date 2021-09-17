package org.sistema.arroz.riceservice.modules.products.application.port.in;

import org.sistema.arroz.riceservice.modules.products.domain.Product;

import java.util.List;

public interface GetAllProductsUseCase {
    List<Product> getAllProducts(Long communityId);
}
