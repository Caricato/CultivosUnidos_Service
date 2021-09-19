package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowProductDetail;

public interface GetMerchandiseProductDetailUseCase {
    Paginator<MerchandiseFlowProductDetail> getMerchandiseProductDetails(Filters filters, Long merchandiseEntryId);
}
