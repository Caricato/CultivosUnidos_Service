package org.sistema.arroz.riceservice.modules.projections.application.port.in;

import org.sistema.arroz.riceservice.modules.products.domain.MonthEnum;

import java.util.List;

public interface ProjectCropsUseCase {
    ProjectionCropsDTO projectCrops(MonthEnum monthEnum, List<ProductsToProject> products);
}
