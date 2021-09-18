package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;

@Data
@Builder
public class SupplyToRegister {
    String supplyName;
    SupplyMetricType supplyMetricType;
    Double stock;
    Double unitPricing;
    Double stockMin;
    Long communityId;
}