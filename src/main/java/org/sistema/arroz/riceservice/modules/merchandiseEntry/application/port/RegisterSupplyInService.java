package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.*;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterSupplyInService implements RegisterSupplyInUseCase {

    private final RegisterMerchandiseEntryUseCase merchandiseEntryUseCase;
    private final RegisterMerchandiseEntryDetailsUseCase merchandiseEntryDetailsUseCase;
    @Override
    public MerchandiseEntryDTO registerSupplyIn(MerchandiseEntryToRegister merchandiseEntryToRegister, List<MerchandiseEntryDetailToRegister> detailsToRegister, Long communityId) {
        var merchandiseEntry = merchandiseEntryUseCase.registerMerchandiseEntry(merchandiseEntryToRegister, communityId);
        var details = merchandiseEntryDetailsUseCase.registerMerchandiseEntryDetails(detailsToRegister, merchandiseEntry);

        return MerchandiseEntryDTO.builder()
                .merchandiseFlow(merchandiseEntry)
                .details(details)
                .build();
    }
}
