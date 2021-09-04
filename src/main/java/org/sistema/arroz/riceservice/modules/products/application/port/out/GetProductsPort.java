package org.sistema.arroz.riceservice.modules.products.application.port.out;

import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

public interface GetProductsPort {
    Paginator<Product> getProducts(Filters filters, Long communityId);
}
