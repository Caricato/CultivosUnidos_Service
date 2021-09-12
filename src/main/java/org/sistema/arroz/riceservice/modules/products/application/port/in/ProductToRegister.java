package org.sistema.arroz.riceservice.modules.products.application.port.in;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductToRegister {
    String productName;
    Double sacks;
    Long communityId;
}
