package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;

@Data
@Builder
public class GetSuppliesBudgetDTO {
    String supplyName;
    Double totalCant;
    String metricType;
    Double unitPricing;
    Double subtotal;
}
