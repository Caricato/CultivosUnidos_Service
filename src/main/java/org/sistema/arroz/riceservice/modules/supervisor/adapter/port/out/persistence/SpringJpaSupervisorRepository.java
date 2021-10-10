package org.sistema.arroz.riceservice.modules.supervisor.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaSupervisorRepository extends JpaRepository<SupervisorJpaEntity, Long> {
}
