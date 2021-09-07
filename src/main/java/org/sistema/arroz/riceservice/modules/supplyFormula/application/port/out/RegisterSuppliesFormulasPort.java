package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out;

import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import java.util.List;

public interface RegisterSuppliesFormulasPort {
    List<SupplyFormula> registerSuppliesFormulas(List<SupplyFormulaToPersist> suppliesFormulas);
}
