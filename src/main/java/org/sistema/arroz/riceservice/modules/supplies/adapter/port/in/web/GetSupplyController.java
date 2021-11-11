package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetSupplyUseCase;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies")
public class GetSupplyController {
    private final GetSupplyUseCase getSupplyUseCase;

    @GetMapping(value= "/detail/{supplyId}")
    public Supply getSupply(@PathVariable Long supplyId){
        return getSupplyUseCase.getSupply(supplyId);
    }
}
