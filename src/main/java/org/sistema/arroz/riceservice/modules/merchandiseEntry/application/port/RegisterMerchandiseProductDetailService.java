package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryDetailToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.RegisterMerchandiseProductDetailUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.MerchandiseProductDetailToPersist;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.RegisterProductDetailPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.UpdateProductStockPort;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterMerchandiseProductDetailService implements RegisterMerchandiseProductDetailUseCase {
    private final GetProductPort getProductPort;
    private final UpdateProductStockPort updateProductStockPort;
    private final RegisterProductDetailPort registerProductDetailPort;

    @Override
    public List<MerchandiseFlowDetail> registerMerchandiseOutDetails(List<MerchandiseEntryDetailToRegister> details, MerchandiseFlow merchandiseFlow) {
        var detailsToPersist = new ArrayList<MerchandiseProductDetailToPersist>(details.size());
        for (MerchandiseEntryDetailToRegister detail: details){
            var detailToPersist = new MerchandiseProductDetailToPersist();
            detailToPersist.setEntryCant(detail.getEntryCant().intValue());
            detailToPersist.setMerchandiseFlow(merchandiseFlow);
            var product = getProductPort.getProductById(detail.getProductId());
            if (product.isEmpty()) throw new ProductNotFoundException(detail.getProductId());
            product.get().setSacks(product.get().getSacks()+detailToPersist.getEntryCant());
            detailToPersist.setProduct(product.get());
            detailsToPersist.add(detailToPersist);

            updateProductStockPort.updateProductStock(product.get().getSacks(), detail.getProductId());
        }
        return registerProductDetailPort.registerProductDetails(detailsToPersist);
    }
}
