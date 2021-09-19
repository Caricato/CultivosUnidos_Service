package org.sistema.arroz.riceservice.modules.supplies.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunityNotFoundException;
import org.sistema.arroz.riceservice.modules.supplies.application.port.RegisterSupplyService;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToRegister;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.RegisterSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyStockInconsistencyException;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyMetricType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class RegisterSupplyServiceTest {

    private final RegisterSupplyPort registerSupplyPort = Mockito.mock(RegisterSupplyPort.class);
    private final GetAgricultureCommunityPort getAgricultureCommunityPort = Mockito.mock(GetAgricultureCommunityPort.class);
    private final RegisterSupplyService registerSupplyService = new RegisterSupplyService(registerSupplyPort, getAgricultureCommunityPort);

    @Test
    void registerSupplySuccess(){
        var supplyToRegister = SupplyToRegister.builder()
                .supplyName("Semillas de arroz seco").stock(100.0).stockMin(50.0).
                unitPricing(5.5).communityId(1L).supplyMetricType(SupplyMetricType.GRAMOS).build();

        var agricultureCommunity = AgricultureCommunity.builder().communityId(1L)
                .communityName("Tambo Seco").build();

        var supply = Supply.builder().supplyId(1L).supplyName("Semillas de arroz seco")
                        .stock(100.0).stockMin(50.0).unitPricing(5.5).supplyMetricType(SupplyMetricType.GRAMOS).community(agricultureCommunity).build();

        when(registerSupplyPort.registerSupply(supplyToRegister, agricultureCommunity)).thenReturn(supply);
        when(getAgricultureCommunityPort.findCommunityById(1L)).thenReturn(agricultureCommunity);

        var testResult = registerSupplyService.registerSupply(supplyToRegister);
        assertThat(testResult).isNotNull();
        assertThat(testResult.getSupplyName()).isEqualTo(supplyToRegister.getSupplyName());
        assertThat(testResult.getCommunity().getCommunityName()).isEqualTo(agricultureCommunity.getCommunityName());
    }

    @Test
    void registerThrowSupplyStockException(){
        var supplyToRegister = SupplyToRegister.builder()
                .supplyName("Semillas de arroz seco").stock(10.0).stockMin(50.0).unitPricing(5.5).
                supplyMetricType(SupplyMetricType.GRAMOS).communityId(1L).build();

        SupplyStockInconsistencyException exception = assertThrows(SupplyStockInconsistencyException.class, () ->{
            var testResult = registerSupplyService.registerSupply(supplyToRegister);
        });

        assertThat(exception.getCode()).isEqualTo("SUP_02");
    }

    @Test
    void registerThrowSupplyCommunityNotFoundException(){
        var supplyToRegister = SupplyToRegister.builder()
                .supplyName("Semillas de arroz seco").stock(100.0).stockMin(50.0).unitPricing(5.5).
                supplyMetricType(SupplyMetricType.GRAMOS).communityId(1L).build();

        AgricultureCommunityNotFoundException exception = assertThrows(AgricultureCommunityNotFoundException.class, () ->{
            var testResult = registerSupplyService.registerSupply(supplyToRegister);
        });

        assertThat(exception.getCode()).isEqualTo("AGC_01");
    }
}
