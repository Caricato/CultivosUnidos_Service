package org.sistema.arroz.riceservice.modules.supervisor.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.RegisterSupervisorUseCase;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.in.SupervisorToRegister;
import org.sistema.arroz.riceservice.modules.supervisor.application.port.out.RegisterSupervisorPort;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;
import org.sistema.arroz.riceservice.modules.users.application.port.in.RegisterUserUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.UserToRegister;
import org.sistema.arroz.riceservice.modules.users.application.port.out.DeleteUserPort;
import org.sistema.arroz.riceservice.modules.users.domain.UserRole;

@UseCase
@RequiredArgsConstructor
public class RegisterSupervisorService implements RegisterSupervisorUseCase {
    private final RegisterSupervisorPort registerSupervisorPort;
    private final RegisterUserUseCase registerUserUseCase;
    private final DeleteUserPort deleteUserPort;

    @Override
    public Supervisor registerSupervisor(SupervisorToRegister supervisorToRegister) {
        var user = registerUserUseCase.registerUser(UserToRegister.builder().username(supervisorToRegister.getDni()).role(UserRole.SUPERVISOR).build());
        var supervisor =  Supervisor.builder().build();
        try{
            supervisor = registerSupervisorPort.registerSupervisor(user, supervisorToRegister);
        }catch(Exception ex){
            deleteUserPort.deleteUser(user.getUserId());
            throw ex;
        }
        return supervisor;
    }
}
