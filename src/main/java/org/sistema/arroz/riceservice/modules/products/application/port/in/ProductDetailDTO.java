package org.sistema.arroz.riceservice.modules.products.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesFormulasDTO;

import java.util.List;

@Data
@Builder
public class ProductDetailDTO {
    Product product;
    List<GetSuppliesFormulasDTO> suppliesFormula;
}
