package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryDetail;

import java.util.List;

public interface RegisterMerchandiseEntryDetailsUseCase {
    List<MerchandiseEntryDetail> registerMerchandiseEntryDetails(List<MerchandiseEntryDetailToRegister> details, MerchandiseEntry merchandiseEntry);
}
