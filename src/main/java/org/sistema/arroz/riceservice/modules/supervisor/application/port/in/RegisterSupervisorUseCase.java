package org.sistema.arroz.riceservice.modules.supervisor.application.port.in;

import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;

public interface RegisterSupervisorUseCase {
    Supervisor registerSupervisor(SupervisorToRegister supervisorToRegister);
}
