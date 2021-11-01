package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.entities.ScheduleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringJpaScheduleRepository extends JpaRepository<ScheduleJpaEntity, Long> {
    List<ScheduleJpaEntity> findAllByProductCommunityJpaEntityCommunityIdOrderByStateAsc(Long communityId);
}
