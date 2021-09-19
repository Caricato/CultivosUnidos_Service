package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.GetMerchandiseEntryDetailUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.GetMerchandiseEntryDetailsPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;

@UseCase
@RequiredArgsConstructor
public class GetMerchandiseEntryDetailService implements GetMerchandiseEntryDetailUseCase {
    private final GetMerchandiseEntryDetailsPort getMerchandiseEntryDetailsPort;

    @Override
    public Paginator<MerchandiseFlowDetail> getMerchandiseEntryDetails(Filters filters, Long merchandiseEntryId) {
        return getMerchandiseEntryDetailsPort.getMerchandiseEntryDetails(filters, merchandiseEntryId);
    }
}
