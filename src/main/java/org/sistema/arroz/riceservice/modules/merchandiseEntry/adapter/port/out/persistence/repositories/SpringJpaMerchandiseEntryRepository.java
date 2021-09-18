package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.entities.MerchandiseFlowJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface SpringJpaMerchandiseEntryRepository extends JpaRepository<MerchandiseFlowJpaEntity, Long> {
    @Query("SELECT M FROM MerchandiseFlowJpaEntity M WHERE M.community.communityId = :communityId AND M.entryDate < :endDate AND M.entryDate >= :startDate ORDER BY M.entryDate DESC")
    Page<MerchandiseFlowJpaEntity> searchMerchandiseEntries(Pageable pageable, @Param("communityId") Long communityId, @Param("startDate")LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
