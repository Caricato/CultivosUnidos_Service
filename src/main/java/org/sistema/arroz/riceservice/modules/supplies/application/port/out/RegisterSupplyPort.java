package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToRegister;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

public interface RegisterSupplyPort {
    Supply registerSupply(SupplyToRegister supplyToRegister, AgricultureCommunity agricultureCommunity);
}
