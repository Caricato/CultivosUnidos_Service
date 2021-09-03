package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.RegisterSupplyUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToRegister;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies")
public class RegisterSupplyController {
    private final RegisterSupplyUseCase registerSupplyUseCase;

    @PostMapping(value = "")
    public Supply registerSupply(@RequestBody SupplyToRegister supplyToRegister){
        return registerSupplyUseCase.registerSupply(supplyToRegister);
    }
}
