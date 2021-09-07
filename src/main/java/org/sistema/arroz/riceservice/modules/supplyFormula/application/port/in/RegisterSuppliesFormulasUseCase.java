package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in;

import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import java.util.List;

public interface RegisterSuppliesFormulasUseCase {
    List<SupplyFormula> registerSuppliesFormulas(List<SupplyFormulaToRegister> suppliesFormulaToRegister, Product product);
}
