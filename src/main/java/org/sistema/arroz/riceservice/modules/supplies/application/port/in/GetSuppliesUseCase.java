package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.util.List;

public interface GetSuppliesUseCase {
    List<Supply> getSupplies(Long communityId);
}
