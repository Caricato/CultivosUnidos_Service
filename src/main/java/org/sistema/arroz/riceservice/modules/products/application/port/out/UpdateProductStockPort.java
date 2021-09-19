package org.sistema.arroz.riceservice.modules.products.application.port.out;

import org.sistema.arroz.riceservice.modules.products.domain.Product;

public interface UpdateProductStockPort {
    Product updateProductStock(Double newStock, Long productId);
}
