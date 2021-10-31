package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.entities.ScheduleDetailJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SpringJpaScheduleDetailRepository extends JpaRepository<ScheduleDetailJpaEntity, Long> {
    Double countAllByProducerProducerIdAndScheduleStateOrScheduleStateAndIsFreeHectaresEquals(Long producerId, Integer state, Integer state2, Boolean isFreeHectares);
    List<ScheduleDetailJpaEntity> findAllByScheduleScheduleId(Long scheduleId);
}
