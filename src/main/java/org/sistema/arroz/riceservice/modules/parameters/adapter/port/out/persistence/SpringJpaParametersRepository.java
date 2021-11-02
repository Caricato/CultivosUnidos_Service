package org.sistema.arroz.riceservice.modules.parameters.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringJpaParametersRepository extends JpaRepository<ParametersJpaEntity, Long> {
    Optional<ParametersJpaEntity> findByCommunity_CommunityId(Long communityId);
}