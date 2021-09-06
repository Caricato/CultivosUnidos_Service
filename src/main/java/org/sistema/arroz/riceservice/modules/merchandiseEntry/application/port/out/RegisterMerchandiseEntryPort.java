package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;

public interface RegisterMerchandiseEntryPort {
    MerchandiseEntry registerMerchandiseEntry(MerchandiseEntryToRegister merchandiseEntryToRegister, AgricultureCommunity community);
}
