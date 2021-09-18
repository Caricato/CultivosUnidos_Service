package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Context;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.ExportBudgetUseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetBudgetDTO;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesBudgetDTO;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesBudgetUseCase;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supply_formula")
public class ExportBudgetController {
    private final ExportBudgetUseCase exportBudgetUseCase;
    private final GetSuppliesBudgetUseCase getSuppliesBudgetUseCase;

    @GetMapping(value ="/reports/{productId}")
    public void exportBudget(@Context HttpServletResponse response,
                               @RequestParam Double hectares, @PathVariable Long productId) throws IOException{
        var supplies =  getSuppliesBudgetUseCase.getSuppliesBudget(productId, hectares);
        var total = 0.0;
        for (GetSuppliesBudgetDTO supply: supplies){
            total+=supply.getSubtotal();
        }
        exportBudgetUseCase.exportBudget(productId, hectares, GetBudgetDTO.builder().supplies(supplies).total(total).build(), response.getOutputStream());
    }
}
