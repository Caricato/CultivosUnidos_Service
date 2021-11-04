package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.LocalDateTimePeruZone;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.mappers.ProductMapper;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.mappers.ScheduleMapper;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.repositories.SpringJpaScheduleRepository;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ScheduleToRegister;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.*;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleFinishedException;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleNotFoundException;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleType;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@PersistenceAdapter
@RequiredArgsConstructor
public class SchedulePersistenceAdapter implements RegisterSchedulePort, DeleteSchedulePort, GetSchedulesPort, GetSchedulePort, FinishSchedulePort, UpdateScheduleStatePort {
    private final ScheduleMapper scheduleMapper;
    private final ProductMapper productMapper;
    private final SpringJpaScheduleRepository scheduleRepository;

    @Override
    public Schedule registerSchedule(ScheduleToRegister scheduleToRegister, Product product) {
        var scheduleJpa = scheduleMapper.toScheduleJpa(scheduleToRegister);
        scheduleJpa.setProduct(productMapper.toProductJpa(product));
        var result = scheduleRepository.save(scheduleJpa);
        return scheduleMapper.toSchedule(result);
    }

    @Transactional
    @Override
    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

    @Override
    public List<Schedule> getActiveSchedules(Long communityId, LocalDate yearDate, LocalDate yearDate2) {
        var entities = scheduleRepository.searchActiveSchedules
                        (communityId, yearDate, yearDate2, yearDate, yearDate2, ScheduleType.PENDING.getValue(), ScheduleType.IN_PROCESS.getValue());
        return scheduleMapper.toSchedules(entities);
    }

    @Override
    public List<Schedule> getFinishedSchedules(Long communityId, LocalDate yearDate, LocalDate endDate) {
        var entities = scheduleRepository.searchFinishedSchedules(communityId, yearDate, endDate, yearDate, endDate, ScheduleType.FINALIZED.getValue());
        return scheduleMapper.toSchedules(entities);
    }

    @Override
    public Schedule getSchedule(Long scheduleId) {
        var entity = scheduleRepository.findById(scheduleId);
        if (entity.isEmpty()) throw new ScheduleNotFoundException(scheduleId);
        return scheduleMapper.toSchedule(entity.get());
    }

    @Override
    public Schedule finishSchedule(Long scheduleId) {
        var entity = scheduleRepository.findById(scheduleId);
        if (entity.isEmpty()) throw new ScheduleNotFoundException(scheduleId);
        if (!Objects.equals(entity.get().getState(), ScheduleType.IN_PROCESS.getValue()))
            throw new ScheduleFinishedException(scheduleId);
        entity.get().setState(ScheduleType.FINALIZED.getValue());
        if (LocalDateTimePeruZone.now().toLocalDate().compareTo(entity.get().getEndDate()) < 0)
            entity.get().setEndDate(LocalDateTimePeruZone.now().toLocalDate());
        var result = scheduleRepository.save(entity.get());
        return scheduleMapper.toSchedule(result);
    }

    @Override
    public List<Schedule> activateSchedules() {
        var nowDate = LocalDate.now();
        var schedulesJpa = scheduleRepository.findAllByStateEqualsAndStartDateBetween(ScheduleType.PENDING.getValue(), nowDate, nowDate);
        schedulesJpa.forEach(scheduleJpaEntity -> scheduleJpaEntity.setState(ScheduleType.IN_PROCESS.getValue()));
        var result = scheduleRepository.saveAll(schedulesJpa);
        return scheduleMapper.toSchedules(result);
    }

    @Override
    public List<Schedule> finishSchedules() {
        var nowDate = LocalDate.now();
        var schedulesJpa = scheduleRepository.findAllByStateEqualsAndEndDateBetween(ScheduleType.IN_PROCESS.getValue(), nowDate, nowDate);
        return scheduleMapper.toSchedules(schedulesJpa);
    }
}
