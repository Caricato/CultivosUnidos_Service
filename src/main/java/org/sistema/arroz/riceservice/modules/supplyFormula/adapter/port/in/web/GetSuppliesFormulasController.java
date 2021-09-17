package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesFormulasDTO;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesFormulasMapper;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesFormulasUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supply_formula")
public class GetSuppliesFormulasController {
    private final GetSuppliesFormulasUseCase getSuppliesFormulasUseCase;
    private final GetSuppliesFormulasMapper getSuppliesFormulasMapper;

    @GetMapping("/{productId}")
    public List<GetSuppliesFormulasDTO> getSuppliesFormulas(@PathVariable Long productId){
        var formulas = getSuppliesFormulasUseCase.getSuppliesFormulas(productId);
        return getSuppliesFormulasMapper.getSuppliesFormulasDTO(formulas);
    }
}
