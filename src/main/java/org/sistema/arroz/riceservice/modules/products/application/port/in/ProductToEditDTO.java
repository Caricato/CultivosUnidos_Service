package org.sistema.arroz.riceservice.modules.products.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.SupplyFormulaToRegister;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductToEditDTO {
    ProductToEdit productToEdit;
    List<SupplyFormulaToRegister> suppliesFormulas;
}
