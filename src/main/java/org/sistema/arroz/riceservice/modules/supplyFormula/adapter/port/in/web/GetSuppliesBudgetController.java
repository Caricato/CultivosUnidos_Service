package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetBudgetDTO;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesBudgetUseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesBudgetDTO;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supply_formula")
public class GetSuppliesBudgetController {
    private final GetSuppliesBudgetUseCase getSuppliesBudgetUseCase;

    @GetMapping("/budget/{productId}")
    public GetBudgetDTO getSuppliesBudget(@PathVariable Long productId,
                                          @RequestParam Double hectares){
        var supplies =  getSuppliesBudgetUseCase.getSuppliesBudget(productId, hectares);
        var total = 0.0;
        for (GetSuppliesBudgetDTO supply: supplies){
            total+=supply.getSubtotal();
        }
        return GetBudgetDTO.builder().supplies(supplies).total(total).build();
    }
}
