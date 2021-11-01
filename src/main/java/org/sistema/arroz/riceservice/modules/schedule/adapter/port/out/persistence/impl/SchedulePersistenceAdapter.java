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
import java.util.List;
import java.util.Objects;

@PersistenceAdapter
@RequiredArgsConstructor
public class SchedulePersistenceAdapter implements RegisterSchedulePort, DeleteSchedulePort, GetSchedulesPort, GetSchedulePort, FinishSchedulePort {
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
    public List<Schedule> getSchedules(Long communityId) {
        var entities = scheduleRepository.findAllByProductCommunityJpaEntityCommunityId(communityId);
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
}
