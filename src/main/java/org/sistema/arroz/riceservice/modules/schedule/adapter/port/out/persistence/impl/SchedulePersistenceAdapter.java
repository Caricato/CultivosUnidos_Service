package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.mappers.ProductMapper;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.mappers.ScheduleMapper;
import org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence.repositories.SpringJpaScheduleRepository;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ScheduleToRegister;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.DeleteSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.RegisterSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;

import javax.transaction.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
public class SchedulePersistenceAdapter implements RegisterSchedulePort, DeleteSchedulePort {
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
}
