package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

public interface UpdateSupplyStockPort {
    Supply updateSupplyStock(Double stockAdded, Long supplyId);
}
