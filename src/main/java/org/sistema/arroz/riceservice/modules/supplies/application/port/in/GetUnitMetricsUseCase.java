package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

import java.util.List;

public interface GetUnitMetricsUseCase {
    List<UnitMetric> getUnitMetrics(Long communityId);
}
