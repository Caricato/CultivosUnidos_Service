package org.sistema.arroz.riceservice.modules.projections.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.products.domain.MonthEnum;

import java.util.List;

@Data
@Builder
public class ProjectionCropsDTO {
    List<ProjectCrops> projectCrops;
    MonthEnum month;
    Double total;
    Double totalCrops;
}
