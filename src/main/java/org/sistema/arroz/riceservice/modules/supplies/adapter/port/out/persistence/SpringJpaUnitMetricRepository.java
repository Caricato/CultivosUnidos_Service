package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringJpaUnitMetricRepository extends JpaRepository<UnitMetricJpaEntity, Long> {
    List<UnitMetricJpaEntity> findAllByCommunity_CommunityIdAndState(Long communityId, Boolean state);
}
