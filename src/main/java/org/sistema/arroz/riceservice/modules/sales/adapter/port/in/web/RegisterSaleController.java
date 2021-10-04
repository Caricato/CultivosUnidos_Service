package org.sistema.arroz.riceservice.modules.sales.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ValidateProductStockUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.RegisterSaleDetailUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.RegisterSaleUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleToRegisterDTO;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;
import org.sistema.arroz.riceservice.modules.sales.domain.SaleInvalidException;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sales")
public class RegisterSaleController {
    private final RegisterSaleUseCase registerSaleUseCase;
    private final RegisterSaleDetailUseCase registerSaleDetailUseCase;
    private final ValidateProductStockUseCase validateProductStockUseCase;

    @PostMapping(value = "")
    public Sale registerSale(@RequestBody SaleToRegisterDTO saleToRegisterDTO){
        var failed = validateProductStockUseCase.validateProductStock(saleToRegisterDTO.getDetail());
        if (!failed.isEmpty()) throw new SaleInvalidException(failed);
        var sale = registerSaleUseCase.registerSale(saleToRegisterDTO.getSaleDate(), saleToRegisterDTO.getDetail(), saleToRegisterDTO.getCommunityId());
        var details = registerSaleDetailUseCase.registerSaleDetail(saleToRegisterDTO.getDetail(), sale);
        return sale;
    }
}
