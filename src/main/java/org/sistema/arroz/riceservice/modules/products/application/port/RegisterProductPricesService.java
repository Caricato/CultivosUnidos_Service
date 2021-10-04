package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductPriceToRegister;
import org.sistema.arroz.riceservice.modules.products.application.port.in.RegisterProductPricesUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.RegisterProductPricesPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.products.domain.ProductPrice;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterProductPricesService implements RegisterProductPricesUseCase {
    private final RegisterProductPricesPort registerProductPricesPort;

    @Override
    public List<ProductPrice> registerProductPrices(List<ProductPriceToRegister> productPricesToRegister, Long productId) {
        return registerProductPricesPort.registerProductPrices(productPricesToRegister, productId);
    }
}
