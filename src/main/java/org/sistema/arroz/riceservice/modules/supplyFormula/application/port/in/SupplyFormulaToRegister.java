package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplyFormulaToRegister {
    Long supplyId;
    Long cantForHectare;
}
