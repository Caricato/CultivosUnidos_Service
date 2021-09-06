package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunityNotFoundException;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.RegisterMerchandiseEntryUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.RegisterMerchandiseEntryPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;

@UseCase
@RequiredArgsConstructor
public class RegisterMerchandiseEntryService implements RegisterMerchandiseEntryUseCase {
    private final RegisterMerchandiseEntryPort registerMerchandiseEntryPort;
    private final GetAgricultureCommunityPort getAgricultureCommunityPort;

    @Override
    public MerchandiseEntry registerMerchandiseEntry(MerchandiseEntryToRegister merchandiseEntryToRegister, Long communityId) {
        var community = getAgricultureCommunityPort.findCommunityById(communityId);
        if (community == null)
            throw new AgricultureCommunityNotFoundException(communityId);
        return registerMerchandiseEntryPort.registerMerchandiseEntry(merchandiseEntryToRegister, community);
    }
}
