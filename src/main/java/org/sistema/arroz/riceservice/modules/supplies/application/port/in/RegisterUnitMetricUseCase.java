package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

public interface RegisterUnitMetricUseCase {
    UnitMetric registerUnitMetric(Long communityId, UnitMetricToRegister unitMetricToRegister);
}
