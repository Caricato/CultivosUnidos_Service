package org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.AgricultureCommunityToRegister;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.RegisterAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.UpdateSupervisorPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunityNotFoundException;
import org.sistema.arroz.riceservice.modules.supervisor.adapter.port.out.persistence.SupervisorMapper;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;

@PersistenceAdapter
@RequiredArgsConstructor
public class AgricultureCommunityPersistenceAdapter implements GetAgricultureCommunityPort, RegisterAgricultureCommunityPort, UpdateSupervisorPort {
    private final SpringJpaAgricultureCommunityRepository agricultureCommunityRepository;
    private final AgricultureCommunityMapper agricultureCommunityMapper;
    private final SupervisorMapper supervisorMapper;

    @Override
    public AgricultureCommunity findCommunityById(Long communityId) {
        var result = agricultureCommunityRepository.findByCommunityIdEquals(communityId);
        return agricultureCommunityMapper.toAgricultureCommunity(result);
    }

    @Override
    public AgricultureCommunity findCommunityBySupervisorDNI(String dni) {
        var result = agricultureCommunityRepository.findBySupervisorDni(dni);
        return agricultureCommunityMapper.toAgricultureCommunity(result);
    }

    @Override
    public AgricultureCommunity registerAgricultureCommunity(AgricultureCommunityToRegister agricultureCommunityToRegister) {
        var communityJpa = agricultureCommunityMapper.toAgricultureCommunityJpaEntity(agricultureCommunityToRegister);
        var result = agricultureCommunityRepository.save(communityJpa);
        return agricultureCommunityMapper.toAgricultureCommunity(result);
    }

    @Override
    public AgricultureCommunity updateSupervisor(Long communityId, Supervisor supervisor) {
        var result = agricultureCommunityRepository.findById(communityId);
        if (result.isEmpty()) throw new AgricultureCommunityNotFoundException(communityId);
        var community = result.get();
        community.setSupervisor(supervisorMapper.toSupervisorJpa(supervisor));
        var jpa = agricultureCommunityRepository.save(community);
        return agricultureCommunityMapper.toAgricultureCommunity(jpa);
    }
}
