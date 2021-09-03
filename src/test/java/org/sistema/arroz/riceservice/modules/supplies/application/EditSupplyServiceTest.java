package org.sistema.arroz.riceservice.modules.supplies.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.modules.supplies.application.port.EditSupplyService;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToEdit;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.EditSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyNotFoundException;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyStockInconsistencyException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class EditSupplyServiceTest {
    private final EditSupplyPort editSupplyPort = Mockito.mock(EditSupplyPort.class);
    private final EditSupplyService editSupplyService = new EditSupplyService(editSupplyPort);

    @Test
    void editSupplySuccess(){
        var supplyToEdit = SupplyToEdit.builder().supplyId(1L)
                .supplyName("Fertilizantes").stockMin(50).supplyMetricType(SupplyMetricType.LITROS).unitPricing(10.5).build();
        var supply = Supply.builder().supplyId(1L).supplyName("Fertilizantes")
                .stockMin(50).supplyMetricType(SupplyMetricType.LITROS).unitPricing(10.5).state(true).stock(200).build();

        when(editSupplyPort.editSupply(supplyToEdit)).thenReturn(supply);
        var testResult = editSupplyService.editSupply(supplyToEdit);
        assertThat(testResult).isNotNull();
        assertThat(testResult.getSupplyName()).isEqualTo(supplyToEdit.getSupplyName());
    }

    @Test
    void editSupplyThrowSupplyStockException(){
        var supplyToEdit = SupplyToEdit.builder().supplyId(1L)
                .supplyName("Fertilizantes").stockMin(50).supplyMetricType(SupplyMetricType.LITROS).unitPricing(10.5).build();
        when(editSupplyPort.editSupply(supplyToEdit)).thenThrow(new SupplyStockInconsistencyException(20 ,supplyToEdit.getStockMin()));

        SupplyStockInconsistencyException exception = assertThrows(SupplyStockInconsistencyException.class, () ->{
            var testResult = editSupplyService.editSupply(supplyToEdit);
        });
        assertThat(exception.getCode()).isEqualTo("SUP_01");
    }

    @Test
    void editSupplyThrowSupplyNotFoundException(){
        var supplyToEdit = SupplyToEdit.builder().supplyId(1L)
                .supplyName("Fertilizantes").stockMin(50).supplyMetricType(SupplyMetricType.LITROS).unitPricing(10.5).build();
        when(editSupplyPort.editSupply(supplyToEdit)).thenThrow(new SupplyNotFoundException(supplyToEdit.getSupplyId()));

        SupplyNotFoundException exception = assertThrows(SupplyNotFoundException.class, () ->{
            var testResult = editSupplyService.editSupply(supplyToEdit);
        });
        assertThat(exception.getCode()).isEqualTo("SUP_02");
        assertThat(exception.getData()).isEqualTo(supplyToEdit.getSupplyId());
    }
}
