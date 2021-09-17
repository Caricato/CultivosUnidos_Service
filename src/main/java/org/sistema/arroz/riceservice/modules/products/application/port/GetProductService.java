package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;

@UseCase
@RequiredArgsConstructor
public class GetProductService implements GetProductUseCase {
    private final GetProductPort getProductPort;

    @Override
    public Product getProductById(Long productId) {
        var optionalProduct = getProductPort.getProductById(productId);
        if (optionalProduct.isEmpty()) throw new ProductNotFoundException(productId);
        return optionalProduct.get();
    }
}
