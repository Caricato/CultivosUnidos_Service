package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in;

import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import java.util.List;

public interface GetSuppliesFormulasUseCase {
    List<SupplyFormula> getSuppliesFormulas(Long productId);
}
