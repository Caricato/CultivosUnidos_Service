package org.sistema.arroz.riceservice.modules.supervisor.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class SupervisorPersistenceAdapter {
    private final SupervisorMapper supervisorMapper;
    private final SpringJpaSupervisorRepository supervisorRepository;
}
