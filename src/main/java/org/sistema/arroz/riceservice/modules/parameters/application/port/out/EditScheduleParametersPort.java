package org.sistema.arroz.riceservice.modules.parameters.application.port.out;

import org.sistema.arroz.riceservice.modules.parameters.application.port.in.ScheduleParametersToRegister;
import org.sistema.arroz.riceservice.modules.parameters.domain.Parameters;

public interface EditScheduleParametersPort {
    Parameters editScheduleParameters(Long communityId, ScheduleParametersToRegister scheduleParametersToRegister);
}
