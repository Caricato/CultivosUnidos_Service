package org.sistema.arroz.riceservice.modules.products.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductUseCase;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class GetProductController {
    private final GetProductUseCase getProductUseCase;

    @GetMapping(value = "/detail/{productId}")
    public Product getProduct(@PathVariable Long productId){
        return getProductUseCase.getProductById(productId);
    }
}
