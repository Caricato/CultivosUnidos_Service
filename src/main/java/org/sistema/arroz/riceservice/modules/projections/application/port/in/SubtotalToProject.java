package org.sistema.arroz.riceservice.modules.projections.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubtotalToProject {
    Long productId;
    Double subtotal;
}
