package org.sistema.arroz.riceservice.modules.supervisor.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringJpaSupervisorRepository extends JpaRepository<SupervisorJpaEntity, Long> {
    Optional<SupervisorJpaEntity> findByDni(String dni);
}
