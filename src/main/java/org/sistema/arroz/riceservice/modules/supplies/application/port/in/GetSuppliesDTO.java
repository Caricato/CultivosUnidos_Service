package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetSuppliesDTO {
    Long supplyId;
    String supplyName;
    Double stock;
    Double unitPricing;
    Double stockMin;
    String supplyMetricType;
}
