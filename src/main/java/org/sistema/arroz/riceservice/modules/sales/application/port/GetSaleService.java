package org.sistema.arroz.riceservice.modules.sales.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.GetSaleUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.GetSalePort;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

@UseCase
@RequiredArgsConstructor
public class GetSaleService implements GetSaleUseCase {
    private final GetSalePort getSalePort;

    @Override
    public Sale getSale(Long saleId) {
        return getSalePort.getSale(saleId);
    }
}
