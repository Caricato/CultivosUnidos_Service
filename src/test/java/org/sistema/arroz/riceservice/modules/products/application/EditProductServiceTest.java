package org.sistema.arroz.riceservice.modules.products.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.modules.products.application.port.EditProductService;
import org.sistema.arroz.riceservice.modules.products.application.port.in.ProductToEdit;
import org.sistema.arroz.riceservice.modules.products.application.port.out.EditProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class EditProductServiceTest {
    private final EditProductPort editProductPort = Mockito.mock(EditProductPort.class);
    private final EditProductService editProductService = new EditProductService(editProductPort);

    @Test
    void editProductSuccess(){
        var productToEdit = ProductToEdit.builder().productName("Arroz seco").build();
        var product = Product.builder().productId(1L).productName("Arroz seco").state(true).build();

        when(editProductPort.editProduct(productToEdit, 1L)).thenReturn(product);

        var testResult = editProductService.editProduct(productToEdit, 1L);

        assertThat(testResult).isNotNull();
        assertThat(testResult.getProductId()).isEqualTo(product.getProductId());
    }

    @Test
    void editProductThrowProductNotFoundException(){
        var productToEdit = ProductToEdit.builder().productName("Arroz seco").build();
        when(editProductPort.editProduct(productToEdit,1L)).thenThrow(new ProductNotFoundException(1L));

        var exception = assertThrows(ProductNotFoundException.class, () ->{
            editProductService.editProduct(productToEdit, 1L);
        });
        assertThat(exception.getCode()).isEqualTo("PROD_01");
        assertThat(exception.getData()).isEqualTo(1L);
    }
}
