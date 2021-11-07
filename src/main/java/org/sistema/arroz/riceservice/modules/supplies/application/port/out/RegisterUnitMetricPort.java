package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.UnitMetricToRegister;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

public interface RegisterUnitMetricPort {
    UnitMetric registerUnitMetric(UnitMetricToRegister unitMetricToRegister, AgricultureCommunity community);
}
