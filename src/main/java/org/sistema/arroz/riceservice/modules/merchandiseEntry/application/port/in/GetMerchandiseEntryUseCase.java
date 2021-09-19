package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;

public interface GetMerchandiseEntryUseCase {
    MerchandiseFlow getMerchandiseEntryById(Long merchandiseEntryId);
}
