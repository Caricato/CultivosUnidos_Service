package org.sistema.arroz.riceservice.modules.supplies.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.modules.supplies.application.port.EditSupplyService;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToEdit;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.EditSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class EditSupplyServiceTest {
    private final EditSupplyPort editSupplyPort = Mockito.mock(EditSupplyPort.class);
    private final EditSupplyService editSupplyService = new EditSupplyService(editSupplyPort);

    @Test
    void editSupplySuccess(){
        var supplyToEdit = SupplyToEdit.builder()
                .supplyName("Fertilizantes").stockMin(50.0).supplyMetricType(1L).unitPricing(10.5).build();
        var supply = Supply.builder().supplyId(1L).supplyName("Fertilizantes")
                .stockMin(50.0).supplyMetricType(UnitMetric.builder().build()).unitPricing(10.5).state(true).stock(200.0).build();

        when(editSupplyPort.editSupply(supplyToEdit, 1L)).thenReturn(supply);
        var testResult = editSupplyService.editSupply(supplyToEdit, 1L);
        assertThat(testResult).isNotNull();
        assertThat(testResult.getSupplyName()).isEqualTo(supplyToEdit.getSupplyName());
    }

    @Test
    void editSupplyThrowSupplyStockException(){
        var supplyToEdit = SupplyToEdit.builder()
                .supplyName("Fertilizantes").stockMin(50.0).supplyMetricType(1L).unitPricing(10.5).build();
        when(editSupplyPort.editSupply(supplyToEdit, 1L)).thenThrow(new SupplyStockInconsistencyException(20.0 ,supplyToEdit.getStockMin()));

        SupplyStockInconsistencyException exception = assertThrows(SupplyStockInconsistencyException.class, () ->{
            var testResult = editSupplyService.editSupply(supplyToEdit, 1L);
        });
        assertThat(exception.getCode()).isEqualTo("SUP_02");
    }

    @Test
    void editSupplyThrowSupplyNotFoundException(){
        var supplyToEdit = SupplyToEdit.builder()
                .supplyName("Fertilizantes").stockMin(50.0).supplyMetricType(1L).unitPricing(10.5).build();
        when(editSupplyPort.editSupply(supplyToEdit,1L)).thenThrow(new SupplyNotFoundException(1L));

        SupplyNotFoundException exception = assertThrows(SupplyNotFoundException.class, () ->{
            var testResult = editSupplyService.editSupply(supplyToEdit, 1L);
        });
        assertThat(exception.getCode()).isEqualTo("SUP_01");
        assertThat(exception.getData()).isEqualTo(1L);
    }
}
