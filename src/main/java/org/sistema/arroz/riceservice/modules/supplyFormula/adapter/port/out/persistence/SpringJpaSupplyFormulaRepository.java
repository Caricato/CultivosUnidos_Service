package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringJpaSupplyFormulaRepository extends JpaRepository<SupplyFormulaJpaEntity, Long> {
}
