package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

@Data
@Builder
@AllArgsConstructor
public class Supply {
    Long supplyId;
    String supplyName;
    Double stock;
    Double unitPricing;
    Double stockMin;
    UnitMetric supplyMetricType;
    Boolean state;
    AgricultureCommunity community;
}