package org.sistema.arroz.riceservice.modules.producers.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerDTO;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducerDTOMapper;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducersUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class GetProducersController {
    private final GetProducersUseCase getProducersUseCase;
    private final GetProducerDTOMapper getProducerDTOMapper;

    @GetMapping(value = "/{communityId}")
    public List<GetProducerDTO> getProducers(@PathVariable Long communityId){
        var producers = getProducersUseCase.getProducers(communityId);
        return getProducerDTOMapper.toProducersDTO(producers);
    }
}
