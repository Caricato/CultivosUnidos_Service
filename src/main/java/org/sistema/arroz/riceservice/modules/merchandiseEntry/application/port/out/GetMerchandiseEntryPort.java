package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;

import java.util.Optional;

public interface GetMerchandiseEntryPort {
    Optional<MerchandiseFlow> getMerchandiseEntryById(Long merchandiseEntryId);
}
