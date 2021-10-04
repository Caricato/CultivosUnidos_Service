package org.sistema.arroz.riceservice.modules.sales.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.GetProductUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ValidateProductStockUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.UpdateProductStockPort;
import org.sistema.arroz.riceservice.modules.products.domain.ProductStockMinBrokenException;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.RegisterSaleDetailUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleDetailToRegister;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.RegisterSaleDetailPort;
import org.sistema.arroz.riceservice.modules.sales.application.port.out.SaleDetailToPersist;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;
import org.sistema.arroz.riceservice.modules.sales.domain.SaleDetail;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterSaleDetailService implements RegisterSaleDetailUseCase {
    private final RegisterSaleDetailPort registerSaleDetailPort;
    private final GetProductUseCase getProductUseCase;
    private final ValidateProductStockUseCase validateProductStockUseCase;
    private final UpdateProductStockPort updateProductStockPort;

    @Override
    public List<SaleDetail> registerSaleDetail(List<SaleDetailToRegister> saleDetailsToRegister, Sale sale) {
        var details = updateProductsStock(saleDetailsToRegister, sale);
        return registerSaleDetailPort.registerSaleDetail(details);
    }

    private List<SaleDetailToPersist> updateProductsStock(List<SaleDetailToRegister> saleDetailsToRegister, Sale sale){
        var details = new ArrayList<SaleDetailToPersist>(saleDetailsToRegister.size());
        for (var saleDetail: saleDetailsToRegister){
            var detailToPersist = new SaleDetailToPersist();
            detailToPersist.setSale(sale);
            detailToPersist.setSubtotal(saleDetail.getSubtotal());
            detailToPersist.setSoldSacks(saleDetail.getSoldSacks());
            detailToPersist.setProduct(getProductUseCase.getProductById(saleDetail.getProductId()));
            updateProductStockPort.lowerProductStock(saleDetail.getSoldSacks(), saleDetail.getProductId());
            details.add(detailToPersist);
        }
        return details;
    }
}
