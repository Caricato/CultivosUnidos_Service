package org.sistema.arroz.riceservice.modules.products.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

@Data
@Builder
@AllArgsConstructor
public class Product {
    Long productId;
    AgricultureCommunity community;
    String productName;
    Boolean state;
    Double sacks;
}
