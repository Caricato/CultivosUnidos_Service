package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaScheduleRepository extends JpaRepository<ScheduleJpaEntity, Long> {
}
