package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;

import java.util.List;

public interface GetSupplyMetricTypesUseCase {
    List<SupplyMetricType> getSupplyMetricTypes();
}
