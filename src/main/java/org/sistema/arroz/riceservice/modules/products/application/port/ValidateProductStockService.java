package org.sistema.arroz.riceservice.modules.products.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductStockFailedDTO;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ValidateProductStockUseCase;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.SaleDetailToRegister;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ValidateProductStockService implements ValidateProductStockUseCase {
    private final GetProductPort getProductPort;

    @Override
    public List<ProductStockFailedDTO> validateProductStock(List<SaleDetailToRegister> saleDetailsToRegister) {
        var failedProduct = new ArrayList<ProductStockFailedDTO>();

        for (SaleDetailToRegister detail: saleDetailsToRegister){
            var soldSacks = detail.getSoldSacks();
            var product = getProductPort.getProductById(detail.getProductId());
            if (product.isEmpty()) throw new ProductNotFoundException(detail.getProductId());
            var actualSacks = product.get().getSacks();

            if (actualSacks < soldSacks) failedProduct.add(ProductStockFailedDTO.builder().
                    productName(product.get().getProductName()).actualSacks(actualSacks).sacksToSell(soldSacks).build());
        }
        return failedProduct;
    }
}
