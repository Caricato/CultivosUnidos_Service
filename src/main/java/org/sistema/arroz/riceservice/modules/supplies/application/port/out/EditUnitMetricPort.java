package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.modules.supplies.application.port.in.UnitMetricToEdit;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

public interface EditUnitMetricPort {
    UnitMetric editUnitMetric(Long unitMetricId, UnitMetricToEdit unitMetricToEdit);
}
