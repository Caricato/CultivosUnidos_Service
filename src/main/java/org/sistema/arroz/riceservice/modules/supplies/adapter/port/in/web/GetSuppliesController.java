package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetSuppliesUseCase;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies")
public class GetSuppliesController {
    private final GetSuppliesUseCase getSuppliesUseCase;

    @GetMapping(value = "/{communityId}")
    public List<Supply> getSupplies(@PathVariable Long communityId){
        return getSuppliesUseCase.getSupplies(communityId);
    }
}
