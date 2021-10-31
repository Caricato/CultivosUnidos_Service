package org.sistema.arroz.riceservice.modules.parameters.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaParametersRepository extends JpaRepository<ParametersJpaEntity, Long> {
}