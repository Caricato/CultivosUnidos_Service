package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.FiltersDate;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunityNotFoundException;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.GetMerchandiseEntriesUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.GetMerchandiseEntriesPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowSubtype;

@UseCase
@RequiredArgsConstructor
public class GetMerchandiseEntriesService implements GetMerchandiseEntriesUseCase {
    private final GetMerchandiseEntriesPort getMerchandiseEntriesPort;
    private final GetAgricultureCommunityPort getAgricultureCommunityPort;

    @Override
    public Paginator<MerchandiseFlow> getMerchandiseEntries(FiltersDate filters, MerchandiseFlowSubtype subtype, Long communityId) {
        var community = getAgricultureCommunityPort.findCommunityById(communityId);
        if (community == null)
            throw new AgricultureCommunityNotFoundException(communityId);
        return getMerchandiseEntriesPort.getMerchandiseEntries(filters, subtype, communityId);
    }
}
