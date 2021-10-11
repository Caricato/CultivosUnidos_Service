package org.sistema.arroz.riceservice.modules.supervisor.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.ValidateSupervisorUseCase;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.out.ValidateSupervisorPort;
import org.sistema.arroz.riceservice.modules.supervisor.domain.SupervisorNotFoundException;

@UseCase
@RequiredArgsConstructor
public class ValidateSupervisorService implements ValidateSupervisorUseCase {
    private final ValidateSupervisorPort validateSupervisorPort;

    @Override
    public void validateSupervisorByDNI(String dni) {
        var isValid = validateSupervisorPort.validateSupervisorByDNI(dni);
        if (!isValid) throw new SupervisorNotFoundException(dni);
    }
}
