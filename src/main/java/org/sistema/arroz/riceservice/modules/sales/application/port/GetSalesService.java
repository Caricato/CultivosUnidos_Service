package org.sistema.arroz.riceservice.modules.sales.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.RangeDatesDTO;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.GetSalesUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.GetSalesPort;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetSalesService implements GetSalesUseCase {
    private final GetSalesPort getSalesPort;

    @Override
    public List<Sale> getSales(Long communityId, RangeDatesDTO datesDTO) {
        return getSalesPort.getSales(communityId, datesDTO);
    }
}
