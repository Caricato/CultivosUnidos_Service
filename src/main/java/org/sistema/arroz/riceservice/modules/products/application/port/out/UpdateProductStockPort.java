package org.sistema.arroz.riceservice.modules.products.application.port.out;

import org.sistema.arroz.riceservice.modules.products.domain.Product;

public interface UpdateProductStockPort {
    Product updateProductStock(Integer newStock, Long productId);
    Product lowerProductStock(Integer reducedStock, Long productId);
}
