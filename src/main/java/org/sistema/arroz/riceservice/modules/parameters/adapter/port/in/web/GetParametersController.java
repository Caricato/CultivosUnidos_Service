package org.sistema.arroz.riceservice.modules.parameters.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.parameters.application.port.in.GetParametersDTO;
import org.sistema.arroz.riceservice.modules.parameters.application.port.in.GetScheduleParametersUseCase;
import org.sistema.arroz.riceservice.modules.parameters.domain.Parameters;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/parameters")
public class GetParametersController {
    private final GetScheduleParametersUseCase getScheduleParametersUseCase;

    @GetMapping(value = "/schedule/{communityId}")
    public List<GetParametersDTO> getParameters(@PathVariable Long communityId){
        var parameters = getScheduleParametersUseCase.getScheduleParameters(communityId);
        var getParametersDTO = new ArrayList<GetParametersDTO>();
        getParametersDTO.add(GetParametersDTO.builder().key("DURACION DEL CRONOGRAMA (EN MESES)").value(parameters.getDurationSchedule().toString()).build());
        return getParametersDTO;
    }
}
