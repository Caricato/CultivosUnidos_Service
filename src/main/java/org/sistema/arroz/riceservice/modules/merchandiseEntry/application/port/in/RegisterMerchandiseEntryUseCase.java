package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;

public interface RegisterMerchandiseEntryUseCase {
    MerchandiseFlow registerMerchandiseEntry(MerchandiseEntryToRegister merchandiseEntryToRegister, Long communityId);
}
