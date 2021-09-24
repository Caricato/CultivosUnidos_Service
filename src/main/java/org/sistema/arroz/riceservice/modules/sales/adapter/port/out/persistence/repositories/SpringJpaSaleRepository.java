package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.entities.SaleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaSaleRepository extends JpaRepository<SaleJpaEntity, Long> {
}
