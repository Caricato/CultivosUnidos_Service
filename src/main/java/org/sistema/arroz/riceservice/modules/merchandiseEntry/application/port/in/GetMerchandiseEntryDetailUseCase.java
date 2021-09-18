package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;

public interface GetMerchandiseEntryDetailUseCase {
    Paginator<MerchandiseFlowDetail> getMerchandiseEntryDetails(Filters filters, Long merchandiseEntryId);
}
