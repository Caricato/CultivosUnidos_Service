package org.sistema.arroz.riceservice.modules.sales.application.port.in;

import org.sistema.arroz.riceservice.modules.sales.domain.Sale;
import org.sistema.arroz.riceservice.modules.sales.domain.SaleDetail;

import java.util.List;

public interface RegisterSaleDetailUseCase {
    List<SaleDetail> registerSaleDetail(List<SaleDetailToRegister> saleDetailsToRegister, Sale sale);
}
