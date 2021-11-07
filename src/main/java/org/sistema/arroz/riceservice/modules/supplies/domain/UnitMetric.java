package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitMetric {
    Long unitMetricId;
    String name;
    Boolean state;
    AgricultureCommunity community;
}
