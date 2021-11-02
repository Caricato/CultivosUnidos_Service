package org.sistema.arroz.riceservice.modules.parameters.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.parameters.application.port.in.GetScheduleParametersUseCase;
import org.sistema.arroz.riceservice.modules.parameters.application.port.out.GetParametersPort;
import org.sistema.arroz.riceservice.modules.parameters.domain.Parameters;

@UseCase
@RequiredArgsConstructor
public class GetParametersService implements GetScheduleParametersUseCase {
    private final GetParametersPort getParametersPort;

    @Override
    public Parameters getScheduleParameters(Long communityId) {
        return getParametersPort.getParameters(communityId);
    }
}
