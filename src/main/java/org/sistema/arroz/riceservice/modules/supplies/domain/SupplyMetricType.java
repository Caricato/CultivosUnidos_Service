package org.sistema.arroz.riceservice.modules.supplies.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SupplyMetricType {
    UNIDADES(0),
    KILOGRAMOS(1),
    GRAMOS(2),
    LITROS(3);

    @Getter
    private final Integer value;
}
