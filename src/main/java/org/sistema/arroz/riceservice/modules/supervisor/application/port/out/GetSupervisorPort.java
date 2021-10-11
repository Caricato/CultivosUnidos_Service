package org.sistema.arroz.riceservice.modules.supervisor.application.port.out;

import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;

public interface GetSupervisorPort {
    Supervisor getSupervisorByDNI(String dni);
}
