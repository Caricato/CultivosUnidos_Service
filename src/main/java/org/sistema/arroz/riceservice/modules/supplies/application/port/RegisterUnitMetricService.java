package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.GetAgricultureCommunityUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.RegisterUnitMetricUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.UnitMetricToRegister;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.RegisterUnitMetricPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

@UseCase
@RequiredArgsConstructor
public class RegisterUnitMetricService implements RegisterUnitMetricUseCase {
    private final RegisterUnitMetricPort registerUnitMetricPort;
    private final GetAgricultureCommunityUseCase getAgricultureCommunityUseCase;

    @Override
    public UnitMetric registerUnitMetric(Long communityId, UnitMetricToRegister unitMetricToRegister) {
        var community = getAgricultureCommunityUseCase.findCommunityById(communityId);
        return registerUnitMetricPort.registerUnitMetric(unitMetricToRegister, community);
    }
}
