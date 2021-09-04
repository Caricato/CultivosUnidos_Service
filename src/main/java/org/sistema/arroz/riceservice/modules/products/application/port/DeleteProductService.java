package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.DeleteProductUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.DeleteProductPort;

@UseCase
@RequiredArgsConstructor
public class DeleteProductService implements DeleteProductUseCase {
    private final DeleteProductPort deleteProductPort;

    @Override
    public Long deleteProduct(Long productId) {
        return deleteProductPort.deleteProduct(productId);
    }
}
