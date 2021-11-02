package org.sistema.arroz.riceservice.modules.parameters.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.parameters.application.port.in.EditScheduleParametersUseCase;
import org.sistema.arroz.riceservice.modules.parameters.application.port.in.ScheduleParametersToRegister;
import org.sistema.arroz.riceservice.modules.parameters.domain.Parameters;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/parameters")
public class EditParametersController {
    private final EditScheduleParametersUseCase editScheduleParametersUseCase;

    @PutMapping(value = "/schedule/{communityId}")
    public Parameters editParameters(@PathVariable Long communityId, @RequestBody ScheduleParametersToRegister parameters){
        return editScheduleParametersUseCase.editScheduleParameters(communityId, parameters);
    }
}
