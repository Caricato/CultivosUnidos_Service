package org.sistema.arroz.riceservice.modules.sales.application.port.in;

import org.sistema.arroz.riceservice.modules.sales.domain.SaleDetail;

import java.util.List;

public interface GetSaleDetailUseCase {
    List<SaleDetail> getSaleDetail(Long saleId);
}
