package org.sistema.arroz.riceservice.modules.products.application.port.out;

import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductPriceToRegister;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.products.domain.ProductPrice;

import java.util.List;

public interface RegisterProductPricesPort {
    List<ProductPrice> registerProductPrices(List<ProductPriceToRegister> productPricesToRegister, Long productId);
}
