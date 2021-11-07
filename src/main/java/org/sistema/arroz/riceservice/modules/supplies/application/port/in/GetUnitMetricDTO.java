package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUnitMetricDTO {
    Long unitMetricId;
    String name;
}
