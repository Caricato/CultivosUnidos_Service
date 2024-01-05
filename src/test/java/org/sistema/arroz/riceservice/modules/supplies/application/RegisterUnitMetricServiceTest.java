package org.sistema.arroz.riceservice.modules.supplies.application;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.GetAgricultureCommunityService;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.GetAgricultureCommunityUseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supplies.application.port.RegisterUnitMetricService;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.UnitMetricToRegister;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.RegisterUnitMetricPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

class RegisterUnitMetricServiceTest {
    private final RegisterUnitMetricPort registerUnitMetricPort = Mockito.mock(RegisterUnitMetricPort.class);
    private final GetAgricultureCommunityPort findAgricultureCommunityPort = Mockito.mock(GetAgricultureCommunityPort.class);
    private final GetAgricultureCommunityUseCase getAgricultureCommunityUseCase = new GetAgricultureCommunityService(findAgricultureCommunityPort);
    private final RegisterUnitMetricService registerUnitMetricService = new RegisterUnitMetricService(registerUnitMetricPort, getAgricultureCommunityUseCase);

    @Test
    void registerUnitMetric(){
        var agricultureCommunity = AgricultureCommunity.builder().communityId(1L)
                .communityName("Tambo Seco").build();

        var unitMetricToRegister = UnitMetricToRegister.builder()
                        .name("Metros").communityId(1L).build();
        when(findAgricultureCommunityPort.findCommunityById(1L)).thenReturn(agricultureCommunity);
        when(getAgricultureCommunityUseCase.findCommunityById(1L)).thenReturn(agricultureCommunity);
        when(registerUnitMetricPort.registerUnitMetric(unitMetricToRegister, agricultureCommunity))
                .thenReturn(UnitMetric.builder().unitMetricId(1L).community(agricultureCommunity).name("Metros").state(true).build());

        var unitMetric = registerUnitMetricService.registerUnitMetric(1L, unitMetricToRegister);
        assertThat(unitMetric.getCommunity().getCommunityName()).isEqualTo(agricultureCommunity.getCommunityName());
    }
}
