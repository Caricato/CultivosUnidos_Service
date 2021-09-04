package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunityNotFoundException;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.application.port.in.RegisterProductUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.RegisterProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

@UseCase
@RequiredArgsConstructor
public class RegisterProductService implements RegisterProductUseCase {
    private final RegisterProductPort registerProductPort;
    private final GetAgricultureCommunityPort getAgricultureCommunityPort;

    @Override
    public Product registerProduct(ProductToRegister productToRegister) {
        var community = getAgricultureCommunityPort.findCommunityById(productToRegister.getCommunityId());
        if (community == null)
            throw new AgricultureCommunityNotFoundException(productToRegister.getCommunityId());
        return registerProductPort.registerProduct(productToRegister, community);
    }
}
