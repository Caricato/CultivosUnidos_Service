package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesBudgetUseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesBudgetDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supply_formula")
public class GetSuppliesBudgetController {
    private final GetSuppliesBudgetUseCase getSuppliesBudgetUseCase;

    @GetMapping("/budget/{productId}")
    public List<GetSuppliesBudgetDTO> getSuppliesBudget(@PathVariable Long productId,
                                                        @RequestParam Integer hectares){
        return getSuppliesBudgetUseCase.getSuppliesBudget(productId, hectares);
    }
}
