package org.sistema.arroz.riceservice.modules.sales.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.GetSaleDTO;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.GetSaleDetailUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.GetSaleUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleDetailDTO;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.mappers.SaleDTOMapper;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.mappers.SaleDetailDTOMapper;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sales")
public class GetSaleDetailController {
    private final GetSaleUseCase getSaleUseCase;
    private final GetSaleDetailUseCase getSaleDetailUseCase;
    private final SaleDTOMapper saleDTOMapper;
    private final SaleDetailDTOMapper saleDetailDTOMapper;

    @GetMapping(value = "/detail/{saleId}")
    public GetSaleDTO getSaleDetail(@PathVariable Long saleId){
        var sale = getSaleUseCase.getSale(saleId);
        var saleDetail = getSaleDetailUseCase.getSaleDetail(saleId);
        return GetSaleDTO.builder().sale(saleDTOMapper.toSaleDTO(sale)).saleDetails(saleDetailDTOMapper.toSaleDetailsDTO(saleDetail))
                .build();
    }
}
