package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;

@Data
public class GetSuppliesFormulasDTO {
    Long supplyFormulaId;
    Long supplyId;
    Long productId;
    String supplyName;
    Integer cantForHectare;
    SupplyMetricType supplyMetricType;
}
