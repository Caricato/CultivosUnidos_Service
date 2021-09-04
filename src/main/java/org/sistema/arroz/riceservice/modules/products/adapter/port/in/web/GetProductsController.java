package org.sistema.arroz.riceservice.modules.products.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductsUseCase;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class GetProductsController {
    private final GetProductsUseCase getProductsUseCase;

    @GetMapping(value = "/{communityId}")
    public Paginator<Product> getProducts(Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search, @PathVariable Long communityId){
        var filters = Filters.builder()
                .page(pageable.getPageNumber())
                .pageSize(pageable.getPageSize())
                .search(search)
                .build();
        return getProductsUseCase.getProducts(filters, communityId);
    }
}
