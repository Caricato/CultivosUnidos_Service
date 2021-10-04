package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductPricesUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPricesPort;
import org.sistema.arroz.riceservice.modules.products.domain.ProductPrice;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetProductPricesService implements GetProductPricesUseCase {
    private final GetProductPricesPort getProductPricesPort;

    @Override
    public List<ProductPrice> getProductPrices(Long productId) {
        return getProductPricesPort.getProductPrices(productId);
    }
}
