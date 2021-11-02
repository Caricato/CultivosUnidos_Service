package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.*;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterSupplyOutService implements RegisterSupplyOutUseCase {
    private final RegisterMerchandiseEntryUseCase merchandiseEntryUseCase;
    private final RegisterMerchandiseOutDetailsUseCase merchandiseOutDetailsUseCase;
    private final ValidateMerchandiseOutUseCase validateMerchandiseOutUseCase;

    @Override
    public MerchandiseEntryDTO registerSupplyOut(MerchandiseEntryToRegister merchandiseOutToRegister, List<MerchandiseEntryDetailToRegister> detailsToRegister, Long communityId) {
        validateMerchandiseOutUseCase.validateMerchandiseOut(detailsToRegister);
        var merchandiseOut = merchandiseEntryUseCase.registerMerchandiseEntry(merchandiseOutToRegister, communityId);
        var detailsOut = merchandiseOutDetailsUseCase.registerMerchandiseOutDetails(detailsToRegister, merchandiseOut);
        return MerchandiseEntryDTO.builder()
                .merchandiseFlow(merchandiseOut)
                .details(detailsOut)
                .build();
    }
}
