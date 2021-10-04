package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductPriceUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPricePort;
import org.sistema.arroz.riceservice.modules.products.domain.ProductPrice;

@UseCase
@RequiredArgsConstructor
public class GetProductPriceService implements GetProductPriceUseCase {
    private final GetProductPricePort getProductPricePort;

    @Override
    public ProductPrice getProductPrice(Long productId, Integer month) {
        return getProductPricePort.getProductPrice(productId, month);
    }
}
