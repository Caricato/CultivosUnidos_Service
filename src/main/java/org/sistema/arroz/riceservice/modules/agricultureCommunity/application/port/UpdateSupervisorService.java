package org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.UpdateSupervisorUseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.UpdateSupervisorPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;

@UseCase
@RequiredArgsConstructor
public class UpdateSupervisorService implements UpdateSupervisorUseCase {
    private final UpdateSupervisorPort updateSupervisorPort;

    @Override
    public AgricultureCommunity updateSupervisor(Long communityId, Supervisor supervisor) {
        return updateSupervisorPort.updateSupervisor(communityId, supervisor);
    }
}
