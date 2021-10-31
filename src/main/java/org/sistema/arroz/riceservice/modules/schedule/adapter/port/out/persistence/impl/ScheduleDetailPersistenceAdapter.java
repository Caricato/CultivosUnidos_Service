package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.mappers.ScheduleDetailMapper;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.mappers.ScheduleMapper;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.repositories.SpringJpaScheduleDetailRepository;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.CountTakenHectaresPort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.GetScheduleDetailsPort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.RegisterScheduleDetailsPort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.ScheduleDetailToRegister;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleType;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class ScheduleDetailPersistenceAdapter implements CountTakenHectaresPort, RegisterScheduleDetailsPort, GetScheduleDetailsPort {
    private final ScheduleDetailMapper scheduleDetailMapper;
    private final ScheduleMapper scheduleMapper;
    private final SpringJpaScheduleDetailRepository scheduleDetailRepository;

    @Override
    public Double takenHectares(Long producerId) {
        return scheduleDetailRepository.countAllByProducerProducerIdAndScheduleStateOrScheduleState(producerId,
                ScheduleType.PENDING.getValue(), ScheduleType.IN_PROCESS.getValue());
    }

    @Override
    public List<ScheduleDetail> registerScheduleDetails(List<ScheduleDetailToRegister> scheduleDetailsToRegister, Schedule schedule) {
        var scheduleDetailsJpa = scheduleDetailMapper.toScheduleDetailsJpa(scheduleDetailsToRegister);
        scheduleDetailsJpa.forEach(scheduleDetailJpaEntity -> scheduleDetailJpaEntity.setSchedule(scheduleMapper.toScheduleJpa(schedule)));
        var result = scheduleDetailRepository.saveAll(scheduleDetailsJpa);
        return scheduleDetailMapper.toScheduleDetails(result);
    }

    @Override
    public List<ScheduleDetail> getScheduleDetails(Long scheduleId) {
        var scheduleDetailsJpa = scheduleDetailRepository.findAllByScheduleScheduleId(scheduleId);
        return scheduleDetailMapper.toScheduleDetails(scheduleDetailsJpa);
    }
}
