package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import java.util.List;

public interface RegisterSupplyInUseCase {
    MerchandiseEntryDTO registerSupplyIn(MerchandiseEntryToRegister productToRegister, List<MerchandiseEntryDetailToRegister> detailsToRegister, Long communityId);
}
