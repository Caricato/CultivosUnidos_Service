package org.sistema.arroz.riceservice.modules.products.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunityNotFoundException;
import org.sistema.arroz.riceservice.modules.products.application.port.RegisterProductService;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToRegister;
import org.sistema.arroz.riceservice.modules.products.application.port.out.RegisterProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class RegisterProductServiceTest {
    private final RegisterProductPort registerProductPort = Mockito.mock(RegisterProductPort.class);
    private final GetAgricultureCommunityPort getAgricultureCommunityPort = Mockito.mock(GetAgricultureCommunityPort.class);
    private final RegisterProductService registerProductService = new RegisterProductService(registerProductPort, getAgricultureCommunityPort);

    @Test
    void registerProductSuccess(){
        var productToRegister = ProductToRegister.builder().productName("Arroz seco").communityId(1L).build();
        var agricultureCommunity = AgricultureCommunity.builder().communityId(1L)
                .communityName("Tambo Seco").build();
        var product = Product.builder().productId(1L).productName("Arroz seco").community(agricultureCommunity).state(true).build();

        when(getAgricultureCommunityPort.findCommunityById(1L)).thenReturn(agricultureCommunity);
        when(registerProductPort.registerProduct(productToRegister, agricultureCommunity)).thenReturn(product);

        var testResult = registerProductService.registerProduct(productToRegister);
        assertThat(testResult).isNotNull();
        assertThat(testResult.getProductId()).isEqualTo(1L);
    }

    @Test
    void registerThrowProductCommunityNotFoundException(){
        var productToRegister = ProductToRegister.builder().productName("Arroz seco").communityId(1L).build();

        AgricultureCommunityNotFoundException exception = assertThrows(AgricultureCommunityNotFoundException.class, () ->{
            var testResult = registerProductService.registerProduct(productToRegister);
        });

        assertThat(exception.getCode()).isEqualTo("AGC_01");
    }
}
