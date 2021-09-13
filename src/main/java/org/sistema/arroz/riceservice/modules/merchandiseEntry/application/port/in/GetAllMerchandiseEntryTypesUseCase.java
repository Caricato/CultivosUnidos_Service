package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryType;

import java.util.List;

public interface GetAllMerchandiseEntryTypesUseCase {
    List<MerchandiseEntryType> getAllMerchandiseEntryTypes();
}
