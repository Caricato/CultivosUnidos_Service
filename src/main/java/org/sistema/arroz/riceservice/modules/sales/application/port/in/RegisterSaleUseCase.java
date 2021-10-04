package org.sistema.arroz.riceservice.modules.sales.application.port.in;

import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

import java.time.LocalDate;
import java.util.List;

public interface RegisterSaleUseCase {
    Sale registerSale(LocalDate saleDate, List<SaleDetailToRegister> details, Long communityId);
}
