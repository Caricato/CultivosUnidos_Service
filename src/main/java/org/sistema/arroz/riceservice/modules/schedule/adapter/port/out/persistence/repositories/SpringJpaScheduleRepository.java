package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.entities.ScheduleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SpringJpaScheduleRepository extends JpaRepository<ScheduleJpaEntity, Long> {
    @Query("SELECT S FROM ScheduleJpaEntity S WHERE S.product.communityJpaEntity.communityId =:communityId AND (S.state = :state1 OR S.state =:state2) AND ((S.startDate BETWEEN :startDate1 AND :startDate2) OR (S.endDate BETWEEN :endDate1 AND :endDate2)) ORDER BY S.state ASC, S.startDate DESC")
    List<ScheduleJpaEntity> searchActiveSchedules(@Param("communityId")Long communityId, @Param("startDate1") LocalDate startDate1, @Param("startDate2") LocalDate startDate2, @Param("endDate1") LocalDate endDate1, @Param("endDate2") LocalDate endDate2, @Param("state1") Integer state1, @Param("state2") Integer state2);

    @Query("SELECT S FROM ScheduleJpaEntity S WHERE S.product.communityJpaEntity.communityId =:communityId AND S.state = :state AND ((S.startDate BETWEEN :startDate1 AND :startDate2) OR (S.endDate BETWEEN :endDate1 AND :endDate2)) ORDER BY S.state ASC, S.startDate DESC")
    List<ScheduleJpaEntity> searchFinishedSchedules(@Param("communityId")Long communityId, @Param("startDate1") LocalDate startDate1, @Param("startDate2") LocalDate startDate2, @Param("endDate1") LocalDate endDate1, @Param("endDate2") LocalDate endDate2, @Param("state") Integer state);
}
