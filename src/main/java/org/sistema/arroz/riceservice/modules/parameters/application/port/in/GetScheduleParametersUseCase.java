package org.sistema.arroz.riceservice.modules.parameters.application.port.in;

import org.sistema.arroz.riceservice.modules.parameters.domain.Parameters;

public interface GetScheduleParametersUseCase {
    Parameters getScheduleParameters(Long communityId);
}
