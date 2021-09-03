package org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.AgricultureCommunityToRegister;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.RegisterAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

@PersistenceAdapter
@RequiredArgsConstructor
public class AgricultureCommunityPersistenceAdapter implements GetAgricultureCommunityPort, RegisterAgricultureCommunityPort {
    private final SpringJpaAgricultureCommunityRepository agricultureCommunityRepository;
    private final AgricultureCommunityMapper agricultureCommunityMapper;

    @Override
    public AgricultureCommunity findCommunityById(Long communityId) {
        var result = agricultureCommunityRepository.findByCommunityIdEquals(communityId);
        return agricultureCommunityMapper.toAgricultureCommunity(result);
    }

    @Override
    public AgricultureCommunity registerAgricultureCommunity(AgricultureCommunityToRegister agricultureCommunityToRegister) {
        var communityJpa = agricultureCommunityMapper.toAgricultureCommunityJpaEntity(agricultureCommunityToRegister);
        var result = agricultureCommunityRepository.save(communityJpa);
        return agricultureCommunityMapper.toAgricultureCommunity(result);
    }
}
