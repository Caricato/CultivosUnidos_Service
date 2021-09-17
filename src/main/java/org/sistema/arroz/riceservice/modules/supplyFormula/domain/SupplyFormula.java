package org.sistema.arroz.riceservice.modules.supplyFormula.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

@Data
@Builder
@AllArgsConstructor
public class SupplyFormula {
    Long supplyFormulaId;
    Supply supply;
    Product product;
    Double cantForHectare;
}
