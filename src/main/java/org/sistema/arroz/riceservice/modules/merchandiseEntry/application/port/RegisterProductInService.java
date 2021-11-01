package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.*;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterProductInService implements RegisterProductInUseCase {
    private final RegisterMerchandiseEntryUseCase merchandiseEntryUseCase;
    private final RegisterMerchandiseProductDetailUseCase merchandiseProductDetailUseCase;

    @Override
    public MerchandiseEntryDTO registerProductIn(MerchandiseEntryToRegister productToRegister, List<MerchandiseEntryDetailToRegister> detailsToRegister, Long communityId) {
        var productIn = merchandiseEntryUseCase.registerMerchandiseEntry(productToRegister, communityId);
        var detailsProduct = merchandiseProductDetailUseCase.registerMerchandiseOutDetails(detailsToRegister, productIn);
        return MerchandiseEntryDTO.builder()
                .merchandiseFlow(productIn)
                .details(detailsProduct)
                .build();
    }
}
