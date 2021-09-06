package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.util.Optional;

public interface GetSupplyPort {
    Optional<Supply> getSupplyById(Long supplyId);
}
