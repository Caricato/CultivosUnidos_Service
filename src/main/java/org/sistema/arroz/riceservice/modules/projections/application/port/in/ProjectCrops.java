package org.sistema.arroz.riceservice.modules.projections.application.port.in;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectCrops {
    Integer productSacks;
    Double crops;
    Double relationSacks;
    Double unitPricing;
    Double subtotal;
}
