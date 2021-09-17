package org.sistema.arroz.riceservice.modules.products.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductDetailDTO; 
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesFormulasMapper;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesFormulasUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class GetProductDetailController {
    private final GetProductUseCase getProductUseCase;
    private final GetSuppliesFormulasUseCase getSuppliesFormulasUseCase;
    private final GetSuppliesFormulasMapper getSuppliesFormulasMapper;

    @GetMapping(value = "/detail/{productId}")
    public ProductDetailDTO getProduct(@PathVariable Long productId){
        var product =  getProductUseCase.getProductById(productId);
        var formulas = getSuppliesFormulasUseCase.getSuppliesFormulas(productId);
        var suppliesFormula =  getSuppliesFormulasMapper.getSuppliesFormulasDTO(formulas);
        return ProductDetailDTO.builder().product(product).suppliesFormula(suppliesFormula).build();
    }
}
