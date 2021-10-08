package org.sistema.arroz.riceservice.modules.producers.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducersUseCase;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class GetProducersController {
    private final GetProducersUseCase getProducersUseCase;

    @GetMapping(value = "/{communityId}")
    public List<Producer> getProducers(@PathVariable Long communityId){
        return getProducersUseCase.getProducers(communityId);
    }
}
