package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

public interface GetSuppliesPort {
    Paginator<Supply> getSupplies(Filters filters, Long communityId);
}
