package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringJpaSupplyFormulaRepository extends JpaRepository<SupplyFormulaJpaEntity, Long> {
    List<SupplyFormulaJpaEntity> findAllByProduct_ProductId(Long productId);
}
