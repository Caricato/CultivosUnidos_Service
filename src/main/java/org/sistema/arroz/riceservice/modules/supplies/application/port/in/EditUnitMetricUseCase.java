package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

public interface EditUnitMetricUseCase {
    UnitMetric editUnitMetric(Long unitMetricId, UnitMetricToEdit unitMetricToEdit);
}
