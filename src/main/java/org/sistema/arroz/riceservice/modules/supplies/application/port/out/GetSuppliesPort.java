package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.util.List;

public interface GetSuppliesPort {
    List<Supply> getSupplies(Long communityId);
}
