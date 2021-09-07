package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

@Data
@Builder
public class SupplyFormulaToPersist {
    Supply supply;
    Product product;
    Long cantForHectare;
}
