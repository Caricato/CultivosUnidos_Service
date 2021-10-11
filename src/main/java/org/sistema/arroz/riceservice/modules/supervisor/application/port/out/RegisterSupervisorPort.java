package org.sistema.arroz.riceservice.modules.supervisor.application.port.out;

import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.SupervisorToRegister;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;
import org.sistema.arroz.riceservice.modules.users.domain.User;

public interface RegisterSupervisorPort {
    Supervisor registerSupervisor(User user, SupervisorToRegister supervisor);
}
