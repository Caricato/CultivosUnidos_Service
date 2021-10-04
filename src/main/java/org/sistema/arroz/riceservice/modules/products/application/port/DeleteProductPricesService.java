package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.DeleteProductPricesUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.DeleteProductPricesPort;

@UseCase
@RequiredArgsConstructor
public class DeleteProductPricesService implements DeleteProductPricesUseCase {
    private final DeleteProductPricesPort deleteProductPricesPort;

    @Override
    public void deleteProductPrices(Long productId) {
        deleteProductPricesPort.deleteProductPrices(productId);
    }
}
