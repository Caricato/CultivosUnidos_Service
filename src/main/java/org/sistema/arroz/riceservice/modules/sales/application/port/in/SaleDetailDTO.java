package org.sistema.arroz.riceservice.modules.sales.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailDTO {
    Long saleDetailId;
    Integer soldSacks;
    Double subtotal;
    String productName;
}
