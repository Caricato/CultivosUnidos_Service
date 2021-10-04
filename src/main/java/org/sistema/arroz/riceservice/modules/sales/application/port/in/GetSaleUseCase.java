package org.sistema.arroz.riceservice.modules.sales.application.port.in;

import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

public interface GetSaleUseCase {
    Sale getSale(Long saleId);
}
