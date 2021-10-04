package org.sistema.arroz.riceservice.modules.products.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.products.domain.MonthEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceToRegister {
    MonthEnum month;
    Double unitPricing;
}
