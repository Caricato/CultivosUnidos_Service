package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out;

import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.FiltersDate;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;

public interface GetMerchandiseEntriesPort {
    Paginator<MerchandiseFlow> getMerchandiseEntries(FiltersDate filters, Long communityId);
}
