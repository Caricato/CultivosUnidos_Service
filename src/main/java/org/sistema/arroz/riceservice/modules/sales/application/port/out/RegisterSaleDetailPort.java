package org.sistema.arroz.riceservice.modules.sales.application.port.out;


import org.sistema.arroz.riceservice.modules.sales.domain.SaleDetail;

import java.util.List;

public interface RegisterSaleDetailPort {
    List<SaleDetail> registerSaleDetail(List<SaleDetailToPersist> saleDetailToPersist);
}
