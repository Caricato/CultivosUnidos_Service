package org.sistema.arroz.riceservice.modules.supplyFormula.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesBudgetUseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesBudgetDTO;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.GetSuppliesFormulasPort;
import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetSuppliesBudgetService implements GetSuppliesBudgetUseCase {
    private final GetSuppliesFormulasPort getSuppliesFormulasPort;

    @Override
    public List<GetSuppliesBudgetDTO> getSuppliesBudget(Long productId, Integer hectares) {
        var suppliesFormulas = getSuppliesFormulasPort.getSuppliesFormulas(productId);
        return updateBudget(suppliesFormulas, hectares);
    }

    private List<GetSuppliesBudgetDTO> updateBudget(List<SupplyFormula> formulas, Integer hectares){
        var getSuppliesList = new ArrayList<GetSuppliesBudgetDTO>(formulas.size());
        for (var formula: formulas){
            var totalHectares = formula.getCantForHectare()*hectares;
            var supplyDTO = GetSuppliesBudgetDTO.builder()
                    .supplyName(formula.getSupply().getSupplyName())
                    .metricType(formula.getSupply().getSupplyMetricType())
                    .unitPricing(formula.getSupply().getUnitPricing())
                    .totalCant(totalHectares).subtotal(totalHectares*formula.getSupply().getUnitPricing()).build();

            getSuppliesList.add(supplyDTO);
        }
        return getSuppliesList;
    }
}
