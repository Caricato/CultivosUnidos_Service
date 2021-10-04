package org.sistema.arroz.riceservice.modules.products.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductPrice {
    Long productPriceId;
    MonthEnum month;
    Double unitPricing;
    Product product;
}
