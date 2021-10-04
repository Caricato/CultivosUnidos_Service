package org.sistema.arroz.riceservice.modules.sales.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.GetSaleDetailUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.GetSaleDetailPort;
import org.sistema.arroz.riceservice.modules.sales.domain.SaleDetail;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetSaleDetailService implements GetSaleDetailUseCase {
    private final GetSaleDetailPort getSaleDetailPort;

    @Override
    public List<SaleDetail> getSaleDetail(Long saleId) {
        return getSaleDetailPort.getSaleDetail(saleId);
    }
}
