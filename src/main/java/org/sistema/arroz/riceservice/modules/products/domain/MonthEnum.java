package org.sistema.arroz.riceservice.modules.products.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MonthEnum {
    ENERO(1), FEBRERO(2), MARZO(3),
    ABRIL(4), MAYO(5), JUNIO(6), JULIO(7),
    AGOSTO(8), SETIEMBRE(9), OCTUBRE(10), NOVIEMBRE(11), DICIEMBRE(12);

    @Getter
    private final Integer value;
}
