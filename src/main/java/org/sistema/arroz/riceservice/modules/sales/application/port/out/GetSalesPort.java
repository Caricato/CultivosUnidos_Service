package org.sistema.arroz.riceservice.modules.sales.application.port.out;

import org.sistema.arroz.riceservice.hexagonal.queries.dates.RangeDatesDTO;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

import java.util.List;

public interface GetSalesPort {
    List<Sale> getSales(Long communityId, RangeDatesDTO datesDTO);
}
