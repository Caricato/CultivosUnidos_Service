package org.sistema.arroz.riceservice.modules.sales.application.port.in;

import org.sistema.arroz.riceservice.hexagonal.queries.dates.RangeDatesDTO;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

import java.util.List;

public interface GetSalesUseCase {
    List<Sale> getSales(Long communityId, RangeDatesDTO datesDTO);
}
