package org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.sales.adapter.port.out.persistence.entities.SaleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SpringJpaSaleRepository extends JpaRepository<SaleJpaEntity, Long> {
    @Query("SELECT S FROM SaleJpaEntity S WHERE S.community.communityId = :communityId AND S.saleDate <= :endDate AND S.saleDate >= :startDate ORDER BY S.saleDate DESC")
    List<SaleJpaEntity> searchSalesForCommunity(@Param("communityId") Long communityId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
