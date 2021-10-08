package org.sistema.arroz.riceservice.modules.users.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.RegisterUserUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.UserToRegister;
import org.sistema.arroz.riceservice.modules.users.application.port.out.RegisterUserPort;
import org.sistema.arroz.riceservice.modules.users.domain.User;

@UseCase
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {
    private final RegisterUserPort registerUserPort;

    @Override
    public User registerUser(UserToRegister userToRegister) {
        return registerUserPort.registerUser(userToRegister);
    }
}
