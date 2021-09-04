package org.sistema.arroz.riceservice.modules.products.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.application.port.in.RegisterProductUseCase;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class RegisterProductController {
    private final RegisterProductUseCase registerProductUseCase;

    @PostMapping(value = "")
    public Product registerProduct(@RequestBody ProductToRegister productToRegister){
        return registerProductUseCase.registerProduct(productToRegister);
    }
}
