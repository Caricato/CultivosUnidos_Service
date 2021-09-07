package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.FiltersDate;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.RangeDatesDTO;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.GetMerchandiseEntriesUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/merchandise_entry")
public class GetMerchandiseEntriesController {
    private final GetMerchandiseEntriesUseCase getMerchandiseEntriesUseCase;

    @GetMapping(value = "/{communityId}")
    public Paginator<MerchandiseEntry> getMerchandiseEntries(Pageable pageable, RangeDatesDTO rangeDatesDTO,
                                                             @PathVariable Long communityId){
        var filters = FiltersDate.builder().page(pageable.getPageNumber()).pageSize(pageable.getPageSize())
                .startDate(rangeDatesDTO.getStartDate().atStartOfDay())
                .endDate(rangeDatesDTO.getEndDate().plusDays(1).atStartOfDay()).build();
        return getMerchandiseEntriesUseCase.getMerchandiseEntries(filters, communityId);
    }
}
