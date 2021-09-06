package org.sistema.arroz.riceservice.modules.merchandiseEntry.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MerchandiseEntryType {
    COMPRA(0),
    ASOCIACION(1);

    @Getter
    private final Integer value;
}
