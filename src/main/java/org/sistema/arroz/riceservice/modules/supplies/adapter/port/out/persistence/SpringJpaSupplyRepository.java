package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringJpaSupplyRepository extends JpaRepository<SupplyJpaEntity, Long> {
    List<SupplyJpaEntity> findAllByCommunityJpaEntity_CommunityIdAndStateOrderBySupplyName(Long communityId, Boolean active);
}
