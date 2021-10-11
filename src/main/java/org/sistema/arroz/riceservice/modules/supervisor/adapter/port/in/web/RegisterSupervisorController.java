package org.sistema.arroz.riceservice.modules.supervisor.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.UpdateSupervisorUseCase;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.RegisterSupervisorUseCase;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.SupervisorToRegister;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.ValidateSupervisorUseCase;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supervisor")
public class RegisterSupervisorController {
    private final ValidateSupervisorUseCase validateSupervisorUseCase;
    private final RegisterSupervisorUseCase registerSupervisorUseCase;
    private final UpdateSupervisorUseCase updateSupervisorUseCase;

    @PostMapping(value = "/{communityId}")
    public Supervisor registerSupervisor(@PathVariable Long communityId, @RequestBody SupervisorToRegister supervisorToRegister){
        validateSupervisorUseCase.validateSupervisorByDNI(supervisorToRegister.getDni());
        var supervisor =  registerSupervisorUseCase.registerSupervisor(supervisorToRegister);
        updateSupervisorUseCase.updateSupervisor(communityId, supervisor);
        return supervisor;
    }
}
