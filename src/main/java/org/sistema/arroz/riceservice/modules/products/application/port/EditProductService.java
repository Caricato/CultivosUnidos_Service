package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.EditProductUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToEdit;
import org.sistema.arroz.riceservice.modules.products.application.port.out.EditProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

@UseCase
@RequiredArgsConstructor
public class EditProductService implements EditProductUseCase {
    private final EditProductPort editProductPort;

    @Override
    public Product editProduct(ProductToEdit productToEdit, Long productId) {
        return editProductPort.editProduct(productToEdit, productId);
    }
}
