package org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;

public interface UpdateSupervisorPort {
    AgricultureCommunity updateSupervisor(Long communityId, Supervisor supervisor);
}
