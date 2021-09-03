package org.sistema.arroz.riceservice.modules.supplies.application;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.modules.supplies.application.port.DeleteSupplyService;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToEdit;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.DeleteSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class DeleteSupplyServiceTest {
    private final DeleteSupplyPort deleteSupplyPort = Mockito.mock(DeleteSupplyPort.class);
    private final DeleteSupplyService deleteSupplyService = new DeleteSupplyService(deleteSupplyPort);

    @Test
    public void deleteSupplySuccess(){
        when(deleteSupplyPort.deleteSupply(1L)).thenReturn(1L);
        var testResult = deleteSupplyService.deleteSupply(1L);

        assertThat(testResult).isEqualTo(1L);
    }

    @Test
    void deleteSupplyThrowSupplyNotFoundException(){
        when(deleteSupplyPort.deleteSupply(1L)).thenReturn(1L).thenThrow(new SupplyNotFoundException(1L));

        SupplyNotFoundException exception = assertThrows(SupplyNotFoundException.class, () ->{
            var testResult = deleteSupplyService.deleteSupply(1L);
        });
        AssertionsForClassTypes.assertThat(exception.getCode()).isEqualTo("SUP_01");
        AssertionsForClassTypes.assertThat(exception.getData()).isEqualTo(1L);
    }
}
