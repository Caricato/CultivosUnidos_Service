package org.sistema.arroz.riceservice.modules.products.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductToEdit {
    String productName;
    Double sacks;
}
