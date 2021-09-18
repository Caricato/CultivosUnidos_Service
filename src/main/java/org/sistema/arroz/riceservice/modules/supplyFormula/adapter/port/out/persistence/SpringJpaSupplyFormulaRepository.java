package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringJpaSupplyFormulaRepository extends JpaRepository<SupplyFormulaJpaEntity, Long> {
    List<SupplyFormulaJpaEntity> findAllByProduct_ProductId(Long productId);
    void deleteAllByProduct_ProductId(Long productId);
    List<SupplyFormulaJpaEntity> findAllBySupply_SupplyIdAndProductState(Long supplyId, Boolean productState);
}
