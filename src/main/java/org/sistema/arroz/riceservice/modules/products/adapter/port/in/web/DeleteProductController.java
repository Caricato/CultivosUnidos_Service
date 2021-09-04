package org.sistema.arroz.riceservice.modules.products.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.products.application.port.in.DeleteProductUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class DeleteProductController {
    private final DeleteProductUseCase deleteProductUseCase;

    @DeleteMapping(value = "/{productId}")
    public Long deleteProduct(@PathVariable Long productId){
        return deleteProductUseCase.deleteProduct(productId);
    }
}
