package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.DeleteSupplyUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies")
public class DeleteSupplyController {
    private final DeleteSupplyUseCase deleteSupplyUseCase;

    @DeleteMapping(value = "/{supplyId}")
    public Long deleteSupply(@PathVariable Long supplyId){
        return deleteSupplyUseCase.deleteSupply(supplyId);
    }
}
