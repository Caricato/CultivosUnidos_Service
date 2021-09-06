package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryDetail;

import java.util.List;

public interface RegisterMerchandiseEntryDetailsPort {
    List<MerchandiseEntryDetail> registerMerchandiseEntryDetails(List<MerchandiseEntryDetailToPersist> details);
}
