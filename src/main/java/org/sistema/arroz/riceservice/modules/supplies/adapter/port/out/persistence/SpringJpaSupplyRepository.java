package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaSupplyRepository extends JpaRepository<SupplyJpaEntity, Long> {
}
