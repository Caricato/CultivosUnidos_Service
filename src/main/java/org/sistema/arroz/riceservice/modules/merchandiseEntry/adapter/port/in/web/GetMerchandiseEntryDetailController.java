package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.MerchandiseEntryFacade;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryPageDTO;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/merchandise_entry")
public class GetMerchandiseEntryDetailController {
    private final MerchandiseEntryFacade merchandiseEntryFacade;

    @GetMapping(value = "/detail/{merchandiseEntryId}")
    public MerchandiseEntryPageDTO getMerchandiseEntryDetail(Pageable pageable, @PathVariable Long merchandiseEntryId){
        var filters = Filters.builder()
                .page(pageable.getPageNumber())
                .pageSize(pageable.getPageSize())
                .build();
        return merchandiseEntryFacade.getMerchandiseEntryDetail(filters, merchandiseEntryId);

    }
}
