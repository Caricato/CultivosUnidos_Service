package org.sistema.arroz.riceservice.modules.producers.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.springframework.web.bind.annotation.*;


@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class GetProducerController {
    private final GetProducerUseCase getProducerUseCase;

    @GetMapping(value = "/detail/{producerId}")
    public Producer getProducer(@PathVariable Long producerId){
        return getProducerUseCase.getProducer(producerId);
    }
}
