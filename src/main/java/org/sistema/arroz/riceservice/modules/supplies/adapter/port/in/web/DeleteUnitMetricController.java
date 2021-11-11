package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.DeleteUnitMetricUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies/unit_metrics")
public class DeleteUnitMetricController {
    private final DeleteUnitMetricUseCase deleteUnitMetricUseCase;

    @DeleteMapping(value = "/{unitMetricId}")
    public void deleteUnitMetric(@PathVariable Long unitMetricId){
        deleteUnitMetricUseCase.deleteUnitMetric(unitMetricId);
    }
}
