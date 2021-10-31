package org.sistema.arroz.riceservice.modules.merchandiseEntry.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MerchandiseFlowType {
    COMPRA(0),
    ASOCIACION(1),
    VENTA(2),
    DESASOCIACION(3),
    CADUCADO(4),
    CRONOGRAMA(5);

    @Getter
    private final Integer value;
}
