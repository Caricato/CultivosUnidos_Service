package org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaAgricultureCommunityRepository extends JpaRepository<AgricultureCommunityJpaEntity, Long> {
    AgricultureCommunityJpaEntity findByCommunityIdEquals(Long communityId);
}
