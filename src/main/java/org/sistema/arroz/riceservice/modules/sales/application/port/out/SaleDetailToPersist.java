package org.sistema.arroz.riceservice.modules.sales.application.port.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailToPersist {
    Sale sale;
    Product product;
    Double subtotal;
    Integer soldSacks;
}
