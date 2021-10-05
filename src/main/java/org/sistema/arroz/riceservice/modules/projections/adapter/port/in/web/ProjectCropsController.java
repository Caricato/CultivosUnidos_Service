package org.sistema.arroz.riceservice.modules.projections.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.products.domain.MonthEnum;
import org.sistema.arroz.riceservice.modules.projections.application.port.in.ProductsToProject;
import org.sistema.arroz.riceservice.modules.projections.application.port.in.ProjectCrops;
import org.sistema.arroz.riceservice.modules.projections.application.port.in.ProjectCropsUseCase;
import org.sistema.arroz.riceservice.modules.projections.application.port.in.ProjectionCropsDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/projections")
public class ProjectCropsController {
    private final ProjectCropsUseCase projectCropsUseCase;

    @GetMapping(value = "/crops")
    public ProjectionCropsDTO projectCrops(MonthEnum month, List<ProductsToProject> products){
        return projectCropsUseCase.projectCrops(month, products);
    }
}
