package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesBudgetUseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesFormulaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supply_budget")
public class GetSuppliesBudgetController {
    private final GetSuppliesBudgetUseCase getSuppliesBudgetUseCase;

    @GetMapping("/{productId}")
    public List<GetSuppliesFormulaDTO> getSuppliesBudget(@PathVariable Long productId,
                                                         @RequestParam Integer hectares){
        return getSuppliesBudgetUseCase.getSuppliesBudget(productId, hectares);
    }
}
