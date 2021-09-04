package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.util.List;

public interface GetAllSuppliesPort {
    List<Supply> getAllSupplies(String search, Long communityId);
}
