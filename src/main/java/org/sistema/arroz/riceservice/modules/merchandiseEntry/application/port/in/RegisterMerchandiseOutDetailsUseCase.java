package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;

import java.util.List;

public interface RegisterMerchandiseOutDetailsUseCase {
    List<MerchandiseFlowDetail> registerMerchandiseOutDetails(List<MerchandiseEntryDetailToRegister> details, MerchandiseFlow merchandiseFlow);
}
