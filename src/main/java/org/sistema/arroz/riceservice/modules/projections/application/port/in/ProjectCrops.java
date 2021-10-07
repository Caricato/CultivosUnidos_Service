package org.sistema.arroz.riceservice.modules.projections.application.port.in;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectCrops {
    String productName;
    Integer productSacks;
    Double crops;
    Double relationSacks;
    Double unitPricing;
    Double subtotal;
}
