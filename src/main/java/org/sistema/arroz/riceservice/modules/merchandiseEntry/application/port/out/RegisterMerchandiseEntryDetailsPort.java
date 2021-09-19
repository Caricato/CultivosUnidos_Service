package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;

import java.util.List;

public interface RegisterMerchandiseEntryDetailsPort {
    List<MerchandiseFlowDetail> registerMerchandiseEntryDetails(List<MerchandiseEntryDetailToPersist> details);
}
