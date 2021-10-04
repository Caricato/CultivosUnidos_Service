package org.sistema.arroz.riceservice.modules.sales.application.port.out;

import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

public interface RegisterSalePort {
    Sale registerSale(SaleToPersist saleToPersist);
}
