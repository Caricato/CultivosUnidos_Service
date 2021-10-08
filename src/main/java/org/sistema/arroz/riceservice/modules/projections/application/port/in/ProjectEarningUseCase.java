package org.sistema.arroz.riceservice.modules.projections.application.port.in;

import org.sistema.arroz.riceservice.modules.products.domain.MonthEnum;

import java.util.List;

public interface ProjectEarningUseCase {
    ProjectionCropsDTO projectEarning(MonthEnum monthEnum, List<SubtotalToProject> subtotalToProjects);
}
