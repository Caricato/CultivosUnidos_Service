package org.sistema.arroz.riceservice.modules.products.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.products.application.port.in.EditProductUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToEditDTO;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.RegisterSuppliesFormulasUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class EditProductController {
    private final EditProductUseCase editProductUseCase;
    private final RegisterSuppliesFormulasUseCase registerSuppliesFormulasUseCase;

    @PutMapping(value = "/{productId}")
    public Product editProduct(@RequestBody ProductToEditDTO productToEditDTO,
                               @PathVariable Long productId){
        var product = editProductUseCase.editProduct(productToEditDTO.getProductToEdit(), productId);
        registerSuppliesFormulasUseCase.registerSuppliesFormulas(productToEditDTO.getSuppliesFormulas(), product);
        return product;
    }
}
