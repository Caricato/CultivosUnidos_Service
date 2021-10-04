package org.sistema.arroz.riceservice.modules.products.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegisterDTO;
import org.sistema.arroz.riceservice.modules.products.application.port.in.RegisterProductPricesUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.RegisterProductUseCase;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.RegisterSuppliesFormulasUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class RegisterProductController {
    private final RegisterProductUseCase registerProductUseCase;
    private final RegisterSuppliesFormulasUseCase registerSuppliesFormulasUseCase;
    private final RegisterProductPricesUseCase registerProductPricesUseCase;

    @PostMapping(value = "")
    public Product registerProduct(@RequestBody ProductToRegisterDTO productToRegister){
        var product = registerProductUseCase.registerProduct(productToRegister.getProductToRegister());
        registerSuppliesFormulasUseCase.registerSuppliesFormulas(productToRegister.getSuppliesFormulas(), product);
        registerProductPricesUseCase.registerProductPrices(productToRegister.getProductPriceToRegisters(), product.getProductId());
        return product;
    }
}
