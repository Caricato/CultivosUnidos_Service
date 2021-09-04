package org.sistema.arroz.riceservice.modules.products.application.port.in;

import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

public interface GetProductsUseCase {
    Paginator<Product> getProducts(Filters filters, Long communityId);
}
