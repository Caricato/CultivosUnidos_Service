package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.entities.ScheduleDetailJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpringJpaScheduleDetailRepository extends JpaRepository<ScheduleDetailJpaEntity, Long> {
    Double countAllByProducerProducerIdAndScheduleStateOrScheduleState(Long producerId, Integer state, Integer state2);
}
