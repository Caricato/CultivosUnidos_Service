package org.sistema.arroz.riceservice.modules.parameters.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.parameters.application.port.in.GetScheduleDurationUseCase;
import org.sistema.arroz.riceservice.modules.parameters.application.port.out.GetParametersPort;

@UseCase
@RequiredArgsConstructor
public class GetScheduleDurationService implements GetScheduleDurationUseCase {
    private final GetParametersPort getParametersPort;

    @Override
    public Integer getScheduleDuration(Long communityId) {
        var parameters = getParametersPort.getParameters(communityId);
        return parameters.getDurationSchedule();
    }
}
