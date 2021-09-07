package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out;

import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import java.util.List;

public interface GetSuppliesFormulasPort {
    List<SupplyFormula> getSuppliesFormulas(Long productId);
}
