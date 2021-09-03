package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

public interface RegisterSupplyUseCase {
    Supply registerSupply(SupplyToRegister supplyToRegister);
}