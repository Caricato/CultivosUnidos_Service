package org.sistema.arroz.riceservice.modules.supervisor.application.port.in;

import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;

public interface GetSupervisorUseCase {
    Supervisor getSupervisorByDNI(String dni);
}
