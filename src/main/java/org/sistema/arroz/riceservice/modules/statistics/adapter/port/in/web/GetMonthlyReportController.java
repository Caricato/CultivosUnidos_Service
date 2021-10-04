package org.sistema.arroz.riceservice.modules.statistics.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.RangeDatesDTO;
import org.sistema.arroz.riceservice.modules.statistics.application.port.in.GetMonthlyReportDTO;
import org.sistema.arroz.riceservice.modules.statistics.application.port.in.GetMonthlyReportUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sales")
public class GetMonthlyReportController {
    private final GetMonthlyReportUseCase getMonthlyReportUseCase;

    @GetMapping(value = "/reports/{communityId}")
    public GetMonthlyReportDTO getMonthlyReportDTO(RangeDatesDTO rangeDatesDTO, @PathVariable Long communityId){
        return getMonthlyReportUseCase.getMonthlyReport(communityId, rangeDatesDTO);
    }
}
