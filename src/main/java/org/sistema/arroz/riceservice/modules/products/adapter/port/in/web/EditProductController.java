package org.sistema.arroz.riceservice.modules.products.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.products.application.port.in.EditProductUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToEdit;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class EditProductController {
    private final EditProductUseCase editProductUseCase;

    @PutMapping(value = "/{productId}")
    public Product editProduct(@RequestBody ProductToEdit productToEdit, @PathVariable Long productId){
        return editProductUseCase.editProduct(productToEdit, productId);
    }
}
