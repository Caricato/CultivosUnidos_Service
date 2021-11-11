package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

public interface GetSupplyUseCase {
    Supply getSupply(Long supplyId);
}
