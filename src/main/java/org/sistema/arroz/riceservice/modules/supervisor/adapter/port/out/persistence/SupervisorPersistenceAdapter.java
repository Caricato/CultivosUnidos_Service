package org.sistema.arroz.riceservice.modules.supervisor.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.SupervisorToRegister;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.out.GetSupervisorPort;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.out.RegisterSupervisorPort;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.out.ValidateSupervisorPort;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;
import org.sistema.arroz.riceservice.modules.supervisor.domain.SupervisorNotFoundException;
import org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence.UserMapper;
import org.sistema.arroz.riceservice.modules.users.domain.User;

@PersistenceAdapter
@RequiredArgsConstructor
public class SupervisorPersistenceAdapter implements ValidateSupervisorPort, RegisterSupervisorPort, GetSupervisorPort {
    private final SupervisorMapper supervisorMapper;
    private final UserMapper userMapper;
    private final SpringJpaSupervisorRepository supervisorRepository;

    @Override
    public boolean validateSupervisorByDNI(String dni) {
        var entity = supervisorRepository.findByDni(dni);
        return entity.isEmpty();
    }

    @Override
    public Supervisor registerSupervisor(User user, SupervisorToRegister supervisorToRegister) {
        var supervisorJpa = supervisorMapper.toSupervisorJpa(supervisorToRegister);
        supervisorJpa.setUser(userMapper.toUserJpa(user));
        var result = supervisorRepository.save(supervisorJpa);
        return supervisorMapper.toSupervisor(result);
    }

    @Override
    public Supervisor getSupervisorByDNI(String dni) {
        var supervisorJpa = supervisorRepository.findByDni(dni);
        if (supervisorJpa.isEmpty()) throw new SupervisorNotFoundException(dni);
        return supervisorMapper.toSupervisor(supervisorJpa.get());
    }
}
