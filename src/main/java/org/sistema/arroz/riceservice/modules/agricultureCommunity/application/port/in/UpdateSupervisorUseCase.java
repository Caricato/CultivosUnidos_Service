package org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;

public interface UpdateSupervisorUseCase {
    AgricultureCommunity updateSupervisor(Long communityId, Supervisor supervisor);
}
