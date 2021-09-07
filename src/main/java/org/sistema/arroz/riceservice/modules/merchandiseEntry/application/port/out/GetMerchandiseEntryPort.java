package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;

import java.util.Optional;

public interface GetMerchandiseEntryPort {
    Optional<MerchandiseEntry> getMerchandiseEntryById(Long merchandiseEntryId);
}
