package org.sistema.arroz.riceservice.modules.products.application.port.in;

import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleDetailToRegister;

import java.util.List;

public interface ValidateProductStockUseCase {
    List<ProductStockFailedDTO> validateProductStock(List<SaleDetailToRegister> saleDetailsToRegister);
}
