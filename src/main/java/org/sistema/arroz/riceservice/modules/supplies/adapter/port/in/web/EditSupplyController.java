package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.EditSupplyUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToEdit;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies")
public class EditSupplyController {
    private final EditSupplyUseCase editSupplyUseCase;

    @PutMapping(value = "")
    public Supply editSupply(@RequestBody SupplyToEdit supplyToEdit){
        return editSupplyUseCase.editSupply(supplyToEdit);
    }
}
