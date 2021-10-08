package org.sistema.arroz.riceservice.modules.producers.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToRegister;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.RegisterProducerUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ValidateProducerToRegisterUseCase;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class RegisterProducerController {
    private final ValidateProducerToRegisterUseCase validateProducerToRegisterUseCase;
    private final RegisterProducerUseCase registerProducerUseCase;

    @PostMapping(value = "/{communityId}")
    public Producer registerProducer(@PathVariable Long communityId, @RequestBody ProducerToRegister producerToRegister){
        validateProducerToRegisterUseCase.validateProducer(producerToRegister.getDni());
        return registerProducerUseCase.registerProducer(communityId, producerToRegister);
    }
}
