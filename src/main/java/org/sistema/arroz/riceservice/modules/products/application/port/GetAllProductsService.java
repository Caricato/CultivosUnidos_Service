package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetAllProductsUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetAllProductsPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetAllProductsService implements GetAllProductsUseCase {
    private final GetAllProductsPort getAllProductsPort;

    @Override
    public List<Product> getAllProducts(Long communityId) {
        return getAllProductsPort.getAllProducts(communityId);
    }
}
