package org.sistema.arroz.riceservice.modules.parameters.application.port.in;

import org.sistema.arroz.riceservice.modules.parameters.domain.Parameters;

public interface EditScheduleParametersUseCase {
    Parameters editScheduleParameters(Long communityId, ScheduleParametersToRegister scheduleParametersToRegister);
}
