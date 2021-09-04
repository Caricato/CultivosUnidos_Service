package org.sistema.arroz.riceservice.modules.products.application.port.out;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

public interface RegisterProductPort {
    Product registerProduct(ProductToRegister productToRegister, AgricultureCommunity agricultureCommunity);
}
