package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.RegisterUnitMetricUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.UnitMetricToRegister;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies/unit_metrics")
public class RegisterUnitMetricController {
    private final RegisterUnitMetricUseCase registerUnitMetricUseCase;

    @PostMapping(value = "")
    public UnitMetric registerUnitMetric(@RequestBody UnitMetricToRegister unitMetricToRegister){
        return registerUnitMetricUseCase.registerUnitMetric(unitMetricToRegister.getCommunityId(), unitMetricToRegister);
    }
}
