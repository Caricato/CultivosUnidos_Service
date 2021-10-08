package org.sistema.arroz.riceservice.modules.producers.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaProducerRepository extends JpaRepository<ProducerJpaEntity, Long> {
}
