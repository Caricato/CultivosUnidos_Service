package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;

public interface GetMerchandiseEntryUseCase {
    MerchandiseEntry getMerchandiseEntryById(Long merchandiseEntryId);
}
