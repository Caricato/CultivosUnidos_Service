package org.sistema.arroz.riceservice.modules.products.adapter.port.in.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.in.web.GetAgricultureCommunityController;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityJpaEntity;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityPersistenceAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.SpringJpaAgricultureCommunityRepository;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.GetAgricultureCommunityService;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.GetAgricultureCommunityUseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.products.AbstractBaseTest;
import org.sistema.arroz.riceservice.modules.supervisor.adapter.port.out.persistence.SupervisorMapper;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.sistema.arroz.riceservice.hexagonal.errors.ErrorMessages.AGC_01_MESSAGE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GetAgricultureCommunityControllerTest extends AbstractBaseTest {
    private static MockMvc mockMvc;
    private GetAgricultureCommunityUseCase getAgricultureCommunityUseCase;
    private GetAgricultureCommunityPort findAgricultureCommunityPort;
    private SpringJpaAgricultureCommunityRepository agricultureCommunityRepository;
    private AgricultureCommunityMapper agricultureCommunityMapper;
    private SupervisorMapper supervisorMapper;

    private GetAgricultureCommunityController getAgricultureCommunityController;

    @BeforeEach
    void init(){
        agricultureCommunityRepository = Mockito.mock(SpringJpaAgricultureCommunityRepository.class);
        agricultureCommunityMapper = Mockito.mock(AgricultureCommunityMapper.class);
        supervisorMapper = Mockito.mock(SupervisorMapper.class);
        findAgricultureCommunityPort = new AgricultureCommunityPersistenceAdapter(agricultureCommunityRepository,
                agricultureCommunityMapper, supervisorMapper);
        getAgricultureCommunityUseCase = new GetAgricultureCommunityService(findAgricultureCommunityPort);
        getAgricultureCommunityController = new GetAgricultureCommunityController(getAgricultureCommunityUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(getAgricultureCommunityController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).build();
    }

    @Test
    @DisplayName("Obtener datos de comunidad agricola - EXITO")
    void getAgricultureCommunity() throws Exception{
        var communityJpaEntity = convertTo("/AgricultureCommunityEntity.json", AgricultureCommunityJpaEntity.class);
        var community = convertTo("/AgricultureCommunity.json", AgricultureCommunity.class);

        Mockito.when(agricultureCommunityRepository.findByCommunityIdEquals(any())).thenReturn(communityJpaEntity);
        Mockito.when(agricultureCommunityMapper.toAgricultureCommunity(any())).thenReturn(community);

        var mvcResult = mockMvc.perform(get("/agriculture_community/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        var communityResult = fromJson(mvcResult.getResponse().getContentAsString(), AgricultureCommunity.class);
        Assertions.assertEquals(communityResult.getCommunityId(), communityJpaEntity.getCommunityId());
    }

    @Test
    @DisplayName("Obtener datos de comunidad agricola - NO EXISTE")
    void getAgricultureCommunity_Exception() {
        Mockito.when(agricultureCommunityRepository.findByCommunityIdEquals(any())).thenReturn(null);
        Mockito.when(agricultureCommunityMapper.toAgricultureCommunity(any())).thenReturn(null);

        try{
            mockMvc.perform(get("/agriculture_community/1")
                    .contentType(MediaType.APPLICATION_JSON)).andReturn();
        }catch (Exception e){
            Assertions.assertEquals(String.format(AGC_01_MESSAGE, 1), e.getCause().getMessage());
        }
    }
}
