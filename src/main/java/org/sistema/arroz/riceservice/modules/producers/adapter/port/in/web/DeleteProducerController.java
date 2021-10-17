package org.sistema.arroz.riceservice.modules.producers.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.DeleteProducerUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class DeleteProducerController {
    private final DeleteProducerUseCase deleteProducerUseCase;

    @DeleteMapping("/{producerId}")
    public void deleteProducer(@PathVariable Long producerId){
        deleteProducerUseCase.deleteProducer(producerId);
    }
}
