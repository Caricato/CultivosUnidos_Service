package org.sistema.arroz.riceservice.modules.producers.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.EditProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToEdit;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ValidateProducerToEditUseCase;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class EditProducerController {
    private final EditProducerUseCase editProducerUseCase;
    private final ValidateProducerToEditUseCase validateProducerToEditUseCase;

    @PutMapping("/{producerId}")
    public Producer editProducer(@PathVariable Long producerId, @RequestBody ProducerToEdit producerToEdit){
        validateProducerToEditUseCase.validateProducer(producerId, producerToEdit);
        return editProducerUseCase.editProducer(producerId, producerToEdit);
    }
}
