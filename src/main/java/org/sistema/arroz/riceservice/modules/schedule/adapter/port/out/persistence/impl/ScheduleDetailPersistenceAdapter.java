package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.mappers.ScheduleDetailMapper;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.mappers.ScheduleMapper;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.repositories.SpringJpaScheduleDetailRepository;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.*;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetailNotFoundException;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleType;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class ScheduleDetailPersistenceAdapter implements CountTakenHectaresPort, RegisterScheduleDetailsPort, GetScheduleDetailsPort, FreeHectaresPort, DeleteScheduleDetailsPort, FreeAllHectaresPort, ValidateProducerSchedulesPort {
    private final ScheduleDetailMapper scheduleDetailMapper;
    private final ScheduleMapper scheduleMapper;
    private final SpringJpaScheduleDetailRepository scheduleDetailRepository;

    @Override
    public Double takenHectares(Long producerId) {
        var hectares =  scheduleDetailRepository.countTakenHectares(producerId,
                ScheduleType.PENDING.getValue(), ScheduleType.IN_PROCESS.getValue(), false);
        if (hectares == null) return 0.0;
        return hectares;
    }

    @Override
    public List<ScheduleDetail> registerScheduleDetails(List<ScheduleDetailToRegister> scheduleDetailsToRegister, Schedule schedule) {
        var scheduleDetailsJpa = scheduleDetailMapper.toScheduleDetailsJpa(scheduleDetailsToRegister);
        scheduleDetailsJpa.forEach(scheduleDetailJpaEntity -> scheduleDetailJpaEntity.setSchedule(scheduleMapper.toScheduleJpa(schedule)));
        scheduleDetailRepository.saveAll(scheduleDetailsJpa);
        return new ArrayList<>(0);
    }

    @Override
    public List<ScheduleDetail> getScheduleDetails(Long scheduleId) {
        var scheduleDetailsJpa = scheduleDetailRepository.findAllByScheduleScheduleId(scheduleId);
        return scheduleDetailMapper.toScheduleDetails(scheduleDetailsJpa);
    }

    @Override
    public void freeHectares(Long scheduleDetailId) {
        var scheduleDetail = scheduleDetailRepository.findById(scheduleDetailId);
        if (scheduleDetail.isEmpty()) throw new ScheduleDetailNotFoundException(scheduleDetailId);
        scheduleDetail.get().setIsFreeHectares(true);
        scheduleDetailRepository.save(scheduleDetail.get());
    }

    @Transactional
    @Override
    public void deleteScheduleDetails(Long scheduleId) {
        scheduleDetailRepository.deleteAllByScheduleScheduleId(scheduleId);
    }

    @Override
    public void freeAllHectares(Long scheduleId) {
        var scheduleDetailsJpa = scheduleDetailRepository.findAllByScheduleScheduleId(scheduleId);
        scheduleDetailsJpa.forEach(scheduleDetailJpaEntity -> scheduleDetailJpaEntity.setIsFreeHectares(true));
        scheduleDetailRepository.saveAll(scheduleDetailsJpa);
    }

    @Override
    public List<ScheduleDetail> validateProducerSchedules(Long producerId) {
        var schedulesDetailsJpa = scheduleDetailRepository.searchActiveSchedulesForProducer(producerId, ScheduleType.IN_PROCESS.getValue(), ScheduleType.PENDING.getValue());
        return scheduleDetailMapper.toScheduleDetails(schedulesDetailsJpa);
    }
}
