package org.sistema.arroz.riceservice.modules.products.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.products.application.port.GetProductsService;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductsPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

class GetProductsServiceTest {
    private final GetProductsPort getProductsPort = Mockito.mock(GetProductsPort.class);
    private final GetProductsService getProductsService = new GetProductsService(getProductsPort);

    @Test
    void getProductsSuccess(){
        var product = Product.builder().productId(1L).productName("Arroz seco").state(true).build();
        var products = new ArrayList<Product>();
        products.add(product);

        var filters = Filters.builder().page(0).pageSize(10).search("").build();
        when(getProductsPort.getProducts(filters, 1L)).thenReturn(Paginator.<Product>builder()
                .total(1L).pageSize(10).page(0).data(products).build());

        var testResult = getProductsService.getProducts(filters, 1L);

        assertThat(testResult).isNotNull();
        assertThat(testResult.getTotal()).isEqualTo(1);
        assertThat(testResult.getData().get(0).getProductId()).isEqualTo(product.getProductId());
    }
}
