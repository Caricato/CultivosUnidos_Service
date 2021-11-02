package org.sistema.arroz.riceservice.modules.parameters.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.parameters.application.port.in.EditScheduleParametersUseCase;
import org.sistema.arroz.riceservice.modules.parameters.application.port.in.ScheduleParametersToRegister;
import org.sistema.arroz.riceservice.modules.parameters.application.port.out.EditScheduleParametersPort;
import org.sistema.arroz.riceservice.modules.parameters.domain.Parameters;

@UseCase
@RequiredArgsConstructor
public class EditScheduleParametersService implements EditScheduleParametersUseCase {
    private final EditScheduleParametersPort editScheduleParametersPort;

    @Override
    public Parameters editScheduleParameters(Long communityId, ScheduleParametersToRegister scheduleParametersToRegister) {
        return editScheduleParametersPort.editScheduleParameters(communityId, scheduleParametersToRegister);
    }
}
