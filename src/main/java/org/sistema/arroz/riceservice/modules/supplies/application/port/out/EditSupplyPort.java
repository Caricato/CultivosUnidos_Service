package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToEdit;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

public interface EditSupplyPort {
    Supply editSupply(SupplyToEdit supplyToEdit, Long supplyId);
}
