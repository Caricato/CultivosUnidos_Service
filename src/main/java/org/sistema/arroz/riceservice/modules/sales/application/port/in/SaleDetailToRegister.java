package org.sistema.arroz.riceservice.modules.sales.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetailToRegister {
    Long productId;
    Integer soldSacks;
    Double subtotal;
}
