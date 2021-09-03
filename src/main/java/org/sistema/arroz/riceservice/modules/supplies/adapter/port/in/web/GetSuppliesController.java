package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetSuppliesUseCase;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;


@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies")
public class GetSuppliesController {
    private final GetSuppliesUseCase getSuppliesUseCase;

    @GetMapping(value = "/{communityId}")
    public Paginator<Supply> getSupplies(Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search, @PathVariable Long communityId){
        var filters = Filters.builder()
                .page(pageable.getPageNumber())
                .pageSize(pageable.getPageSize())
                .search(search)
                .build();
        return getSuppliesUseCase.getSupplies(filters, communityId);
    }
}
