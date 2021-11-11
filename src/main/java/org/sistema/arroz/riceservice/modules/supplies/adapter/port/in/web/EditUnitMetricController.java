package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.EditUnitMetricUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.UnitMetricToEdit;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies/unit_metrics")
public class EditUnitMetricController {
    private final EditUnitMetricUseCase editUnitMetricUseCase;

    @PutMapping(value = "/{unitMetricId}")
    public UnitMetric editUnitMetric(@RequestBody UnitMetricToEdit unitMetricToEdit, @PathVariable Long unitMetricId){
        return editUnitMetricUseCase.editUnitMetric(unitMetricId, unitMetricToEdit);
    }
}
