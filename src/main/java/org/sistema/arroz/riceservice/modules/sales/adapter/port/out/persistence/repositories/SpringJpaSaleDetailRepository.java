package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.entities.SaleDetailJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaSaleDetailRepository extends JpaRepository<SaleDetailJpaEntity, Long> {
}
