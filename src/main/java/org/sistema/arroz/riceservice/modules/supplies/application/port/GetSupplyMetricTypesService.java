package org.sistema.arroz.riceservice.modules.supplies.application.port;

import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetSupplyMetricTypesUseCase;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;

import java.util.ArrayList;
import java.util.List;

@UseCase
public class GetSupplyMetricTypesService implements GetSupplyMetricTypesUseCase {
    @Override
    public List<SupplyMetricType> getSupplyMetricTypes() {
        var metricTypes = new ArrayList<SupplyMetricType>();
        metricTypes.add(SupplyMetricType.UNIDADES);
        metricTypes.add(SupplyMetricType.KILOGRAMOS);
        metricTypes.add(SupplyMetricType.GRAMOS);
        metricTypes.add(SupplyMetricType.LITROS);
        return metricTypes;
    }
}
