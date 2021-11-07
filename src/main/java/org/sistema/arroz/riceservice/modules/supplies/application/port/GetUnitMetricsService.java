package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetUnitMetricsUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetUnitMetricsPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetUnitMetricsService implements GetUnitMetricsUseCase {
    private final GetUnitMetricsPort getUnitMetricsPort;

    @Override
    public List<UnitMetric> getUnitMetrics(Long communityId) {
        return getUnitMetricsPort.getActiveUnitMetrics(communityId);
    }
}
