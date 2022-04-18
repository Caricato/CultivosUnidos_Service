package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.repositories;

import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.entities.ScheduleDetailJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SpringJpaScheduleDetailRepository extends JpaRepository<ScheduleDetailJpaEntity, Long> {
    @Query("SELECT SUM(SD.hectares) FROM ScheduleDetailJpaEntity SD WHERE SD.producer.producerId = :producerId AND (SD.schedule.state = :state1 OR SD.schedule.state = :state2) AND SD.isFreeHectares = :isFreeHectares GROUP BY SD.producer")
    Double countTakenHectares(@Param("producerId") Long producerId, @Param("state1") Integer state1, @Param("state2")  Integer state2, @Param("isFreeHectares")  Boolean isFreeHectares);

    List<ScheduleDetailJpaEntity> findAllByScheduleScheduleId(Long scheduleId);
    void deleteAllByScheduleScheduleId(Long scheduleId);

    @Query("SELECT SD FROM ScheduleDetailJpaEntity SD WHERE SD.producer.producerId = :producerId AND (SD.schedule.state = :state1 OR SD.schedule.state = :state2)")
    List<ScheduleDetailJpaEntity> searchActiveSchedulesForProducer(@Param("producerId") Long producerId, @Param("state1") Integer state1, @Param("state2") Integer state2);
}
