package org.sistema.arroz.riceservice.modules.sales.application.port.out;

import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

public interface GetSalePort {
    Sale getSale(Long saleId);
}
