package org.sistema.arroz.riceservice.modules.products.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.modules.products.application.port.DeleteProductService;
import org.sistema.arroz.riceservice.modules.products.application.port.out.DeleteProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class DeleteProductServiceTest {
    private final DeleteProductPort deleteProductPort = Mockito.mock(DeleteProductPort.class);
    private final DeleteProductService deleteProductService = new DeleteProductService(deleteProductPort);

    @Test
    void deleteProductSuccess(){
        when(deleteProductPort.deleteProduct(1L)).thenReturn(1L);
        var testResult = deleteProductService.deleteProduct(1L);

        assertThat(testResult).isEqualTo(1L);
    }

    @Test
    void deleteProductThrowsProductNotFoundException(){
        when(deleteProductPort.deleteProduct(1L)).thenThrow(new ProductNotFoundException(1L));
        var exception = assertThrows(ProductNotFoundException.class, () ->{
            var testResult = deleteProductService.deleteProduct(1L);
        });

        assertThat(exception.getCode()).isEqualTo("PROD_01");
        assertThat(exception.getData()).isEqualTo(1L);
    }
}
