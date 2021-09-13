package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;

@Data
@Builder
@AllArgsConstructor
public class GetAllSuppliesForEntriesDTO {
    Long supplyId;
    String supplyName;
    SupplyMetricType supplyMetricType;
}
