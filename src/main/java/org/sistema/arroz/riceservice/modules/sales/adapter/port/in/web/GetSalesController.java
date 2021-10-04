package org.sistema.arroz.riceservice.modules.sales.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.RangeDatesDTO;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.GetSalesUseCase;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sales")
public class GetSalesController {
    private final GetSalesUseCase getSalesUseCase;

    @GetMapping(value = "/{communityId}")
    public List<Sale> getSales(RangeDatesDTO rangeDatesDTO,
                               @PathVariable Long communityId){
        return getSalesUseCase.getSales(communityId, rangeDatesDTO);
    }
}
