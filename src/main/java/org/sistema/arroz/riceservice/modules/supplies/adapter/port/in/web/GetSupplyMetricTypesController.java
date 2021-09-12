package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetSupplyMetricTypesUseCase;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies")
public class GetSupplyMetricTypesController {
    private final GetSupplyMetricTypesUseCase getSupplyMetricTypesUseCase;

    @GetMapping(value = "/metric_types")
    public List<SupplyMetricType> getSupplyMetricTypes(){
        return getSupplyMetricTypesUseCase.getSupplyMetricTypes();
    }
}
