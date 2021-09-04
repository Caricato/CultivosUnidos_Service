package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductsUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductsPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

@UseCase
@RequiredArgsConstructor
public class GetProductsService implements GetProductsUseCase {
    private final GetProductsPort getProductsPort;

    @Override
    public Paginator<Product> getProducts(Filters filters, Long communityId) {
        return getProductsPort.getProducts(filters, communityId);
    }
}
