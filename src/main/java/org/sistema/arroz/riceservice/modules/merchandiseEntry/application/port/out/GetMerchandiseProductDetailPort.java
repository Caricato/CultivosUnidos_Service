package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out;

import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowProductDetail;

public interface GetMerchandiseProductDetailPort {
    Paginator<MerchandiseFlowProductDetail> getMerchandiseProductDetails(Filters filters, Long merchandiseEntryId);
}
