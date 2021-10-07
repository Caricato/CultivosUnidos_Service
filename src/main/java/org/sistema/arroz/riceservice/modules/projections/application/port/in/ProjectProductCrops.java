package org.sistema.arroz.riceservice.modules.projections.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.products.domain.MonthEnum;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectProductCrops {
    MonthEnum month;
    List<ProductsToProject> products;
}
