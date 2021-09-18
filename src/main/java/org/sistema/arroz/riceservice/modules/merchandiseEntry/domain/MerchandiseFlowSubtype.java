package org.sistema.arroz.riceservice.modules.merchandiseEntry.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MerchandiseFlowSubtype {
    ENTRADA_INSUMO(0),
    SALIDA_INSUMO(1),
    ENTRADA_PRODUCTO(2);

    @Getter
    private final Integer value;

    public static boolean checkInEnum(MerchandiseFlowSubtype merchandiseFlowSubtype){
        for (MerchandiseFlowSubtype item: MerchandiseFlowSubtype.values()){
            if (merchandiseFlowSubtype == item) return true;
        }
        return false;
    }
}
