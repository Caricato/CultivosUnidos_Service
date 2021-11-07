package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

import java.util.List;

public interface GetUnitMetricsPort {
    List<UnitMetric> getActiveUnitMetrics(Long communityId);
}
