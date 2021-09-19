package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.GetMerchandiseEntryDetailUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.GetMerchandiseProductDetailUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.GetMerchandiseEntryDetailsPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.GetMerchandiseProductDetailPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowProductDetail;

@UseCase
@RequiredArgsConstructor
public class GetMerchandiseEntryDetailService implements GetMerchandiseEntryDetailUseCase, GetMerchandiseProductDetailUseCase {
    private final GetMerchandiseEntryDetailsPort getMerchandiseEntryDetailsPort;
    private final GetMerchandiseProductDetailPort getMerchandiseProductDetailPort;

    @Override
    public Paginator<MerchandiseFlowDetail> getMerchandiseEntryDetails(Filters filters, Long merchandiseEntryId) {
        return getMerchandiseEntryDetailsPort.getMerchandiseEntryDetails(filters, merchandiseEntryId);
    }

    @Override
    public Paginator<MerchandiseFlowProductDetail> getMerchandiseProductDetails(Filters filters, Long merchandiseEntryId) {
        return getMerchandiseProductDetailPort.getMerchandiseProductDetails(filters, merchandiseEntryId);
    }
}
