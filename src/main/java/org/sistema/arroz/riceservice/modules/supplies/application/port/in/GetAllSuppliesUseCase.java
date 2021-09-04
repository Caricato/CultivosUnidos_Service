package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.util.List;

public interface GetAllSuppliesUseCase {
    List<Supply> getAllSupplies(String search, Long communityId);
}
