package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;

public interface RegisterMerchandiseEntryUseCase {
    MerchandiseEntry registerMerchandiseEntry(MerchandiseEntryToRegister merchandiseEntryToRegister, Long communityId);
}
