package org.sistema.arroz.riceservice.modules.supplies.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.modules.supplies.application.port.GetSuppliesService;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetSuppliesPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

class GetSuppliesServiceTest {
    private final GetSuppliesPort getSuppliesPort = Mockito.mock(GetSuppliesPort.class);
    private final GetSuppliesService getSuppliesService = new GetSuppliesService(getSuppliesPort);

    @Test
    void getSuppliesSuccess(){
        var supply = Supply.builder().supplyId(1L).supplyName("Fertilizantes")
                .stockMin(50).supplyMetricType(SupplyMetricType.LITROS).unitPricing(10.5).state(true).stock(200).build();
        var supplies = new ArrayList<Supply>();
        supplies.add(supply);

        when(getSuppliesPort.getSupplies(1L)).thenReturn(supplies);
        var testResult = getSuppliesService.getSupplies(1L);

        assertThat(testResult).isNotNull();
        assertThat(testResult.size()).isEqualTo(1);
        assertThat(testResult.get(0).getSupplyId()).isEqualTo(supply.getSupplyId());
    }
}
