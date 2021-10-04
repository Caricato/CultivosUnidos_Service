package org.sistema.arroz.riceservice.modules.sales.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetail {
    Long saleDetailId;
    Integer soldSacks;
    Double subtotal;
    Double theoreticalSubtotal;
    Sale sale;
    Product product;
}
