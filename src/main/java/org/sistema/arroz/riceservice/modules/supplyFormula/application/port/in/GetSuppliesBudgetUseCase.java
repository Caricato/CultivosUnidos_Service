package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in;


import java.util.List;

public interface GetSuppliesBudgetUseCase {
    List<GetSuppliesFormulaDTO> getSuppliesBudget(Long productId, Integer hectares);
}
