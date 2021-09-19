package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowType;

import java.util.List;

public interface GetAllMerchandiseEntryTypesUseCase {
    List<MerchandiseFlowType> getAllMerchandiseEntryTypes();
}
