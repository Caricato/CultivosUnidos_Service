package org.sistema.arroz.riceservice.modules.producers.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerDTO;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerDTOMapper;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerUseCase;
import org.springframework.web.bind.annotation.*;


@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class GetProducerController {
    private final GetProducerUseCase getProducerUseCase;
    private final GetProducerDTOMapper getProducerDTOMapper;

    @GetMapping(value = "/detail/{producerId}")
    public GetProducerDTO getProducer(@PathVariable Long producerId){
        var producer = getProducerUseCase.getProducer(producerId);
        return getProducerDTOMapper.getProducerDTO(producer);
    }
}
