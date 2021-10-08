package org.sistema.arroz.riceservice.modules.projections.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.projections.application.port.in.*;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/projections")
public class ProjectEarningController {
    private final ProjectEarningUseCase projectEarningUseCase;

    @PostMapping(value = "/earnings")
    public ProjectionCropsDTO projectCrops(@RequestBody ProjectEarning projectEarning){
        return projectEarningUseCase.projectEarning(projectEarning.getMonth(), projectEarning.getProducts());
    }
}
