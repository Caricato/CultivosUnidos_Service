package org.sistema.arroz.riceservice.modules.products.application.port.out;

import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToEdit;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

public interface EditProductPort {
    Product editProduct(ProductToEdit productToEdit, Long productId);
}
