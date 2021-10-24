package org.sistema.arroz.riceservice.modules.schedule.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class SchedulePersistenceAdapter {
    private final ScheduleMapper scheduleMapper;
    private final SpringJpaScheduleRepository scheduleRepository;
}
