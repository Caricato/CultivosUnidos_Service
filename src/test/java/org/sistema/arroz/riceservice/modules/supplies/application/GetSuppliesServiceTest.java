package org.sistema.arroz.riceservice.modules.supplies.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.supplies.application.port.GetSuppliesService;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetSuppliesPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

class GetSuppliesServiceTest {
    private final GetSuppliesPort getSuppliesPort = Mockito.mock(GetSuppliesPort.class);
    private final GetSuppliesService getSuppliesService = new GetSuppliesService(getSuppliesPort);

    @Test
    void getSuppliesSuccess(){
        var supply = Supply.builder().supplyId(1L).supplyName("Fertilizantes")
                .stockMin(50.0).supplyMetricType(UnitMetric.builder().build()).unitPricing(10.5).state(true).stock(200.0).build();
        var supplies = new ArrayList<Supply>();
        supplies.add(supply);
        var filters = Filters.builder().page(0).pageSize(10).search("").build();

        when(getSuppliesPort.getSupplies(filters,1L)).thenReturn(Paginator.<Supply>builder()
                .total(1L).pageSize(10).page(0).data(supplies).build());
        var testResult = getSuppliesService.getSupplies(filters, 1L);

        assertThat(testResult).isNotNull();
        assertThat(testResult.getTotal()).isEqualTo(1);
        assertThat(testResult.getData().get(0).getSupplyId()).isEqualTo(supply.getSupplyId());
    }
}
