package org.sistema.arroz.riceservice.modules.sales.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPricePort;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;
import org.sistema.arroz.riceservice.modules.products.domain.ProductPriceNotFoundException;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.RegisterSaleUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleDetailToRegister;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleToRegister;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleToRegisterDTO;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.RegisterSaleDetailPort;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.RegisterSalePort;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.SaleToPersist;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;

import java.time.LocalDate;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterSaleService implements RegisterSaleUseCase {
    private final RegisterSalePort registerSalePort;
    private final GetProductPort getProductPort;
    private final GetProductPricePort getProductPricePort;
    private final GetAgricultureCommunityPort getAgricultureCommunityPort;

    @Override
    public Sale registerSale(LocalDate saleDate, List<SaleDetailToRegister> details, Long communityId) {
        var saleToPersist = new SaleToPersist();
        saleToPersist.setSaleDate(saleDate);
        saleToPersist.setCommunity(getAgricultureCommunityPort.findCommunityById(communityId));
        saleToPersist.setSaleTotal(calculateTotal(details));
        saleToPersist.setTheoreticalTotal(calculateTheoreticalTotal(details,saleDate));
        //TODO CALCULATE HISTORICAL
        return registerSalePort.registerSale(saleToPersist);
    }

    private Double calculateTotal(List<SaleDetailToRegister> details){
        var total = 0.0;
        for (SaleDetailToRegister detail: details){
            total+=detail.getSubtotal();
        }
        return total;
    }

    private double calculateTheoreticalTotal(List<SaleDetailToRegister> details, LocalDate date){
        var total = 0.0;
        for (SaleDetailToRegister detail: details){
            var productOptional = getProductPort.getProductById(detail.getProductId());
            if (productOptional.isEmpty()) throw new ProductNotFoundException(detail.getProductId());
            var productPrice = getProductPricePort.getProductPrice(productOptional.get().getProductId(), date.getMonthValue());
            if (productPrice == null) throw new ProductPriceNotFoundException(productOptional.get().getProductId(), date.getMonthValue());

            total+= detail.getSoldSacks()*productPrice.getUnitPricing();
        }
        return total;
    }
}
