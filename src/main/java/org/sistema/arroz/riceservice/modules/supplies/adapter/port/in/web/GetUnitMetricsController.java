package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetUnitMetricDTO;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetUnitMetricDTOMapper;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetUnitMetricsUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies/unit_metrics")
public class GetUnitMetricsController {
    private final GetUnitMetricsUseCase getUnitMetricsUseCase;
    private final GetUnitMetricDTOMapper getUnitMetricDTOMapper;

    @GetMapping(value = "/{communityId}")
    public List<GetUnitMetricDTO> getUnitMetrics(@PathVariable Long communityId){
        var unitMetrics = getUnitMetricsUseCase.getUnitMetrics(communityId);
        return getUnitMetricDTOMapper.toUnitMetricDTOs(unitMetrics);
    }
}
