package org.sistema.arroz.riceservice.modules.products.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetAllProductsUseCase;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class GetAllProductsController {
    private final GetAllProductsUseCase getAllProductsUseCase;

    @GetMapping(value = "/aux/{communityId}")
    public List<Product> getAllProducts(@PathVariable Long communityId){
        return getAllProductsUseCase.getAllProducts(communityId);
    }
}
