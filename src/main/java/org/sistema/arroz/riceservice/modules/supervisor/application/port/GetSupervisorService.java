package org.sistema.arroz.riceservice.modules.supervisor.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.GetSupervisorUseCase;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.out.GetSupervisorPort;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;

@UseCase
@RequiredArgsConstructor
public class GetSupervisorService implements GetSupervisorUseCase {
    private final GetSupervisorPort getSupervisorPort;

    @Override
    public Supervisor getSupervisorByDNI(String dni) {
        return getSupervisorPort.getSupervisorByDNI(dni);
    }
}
