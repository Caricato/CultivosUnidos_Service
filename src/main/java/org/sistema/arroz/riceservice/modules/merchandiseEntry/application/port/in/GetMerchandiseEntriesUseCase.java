package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.FiltersDate;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;

public interface GetMerchandiseEntriesUseCase {
    Paginator<MerchandiseFlow> getMerchandiseEntries(FiltersDate filters, Long communityId);
}
