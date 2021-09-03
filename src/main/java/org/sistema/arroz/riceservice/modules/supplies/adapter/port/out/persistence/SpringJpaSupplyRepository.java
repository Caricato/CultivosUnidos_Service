package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringJpaSupplyRepository extends JpaRepository<SupplyJpaEntity, Long> {
    @Query("SELECT S FROM SupplyJpaEntity S WHERE S.communityJpaEntity.communityId = :communityId AND S.state = :state AND (UPPER(S.supplyName) LIKE CONCAT('%', UPPER(:search), '%' )) ORDER BY S.supplyName DESC")
    Page<SupplyJpaEntity> searchSupplies(Pageable pageable, @Param("search") String search, @Param("communityId") Long communityId, @Param("state") Boolean state);
}
