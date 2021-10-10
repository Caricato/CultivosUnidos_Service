package org.sistema.arroz.riceservice.modules.users.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GetUserUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.out.GetUserPort;
import org.sistema.arroz.riceservice.modules.users.domain.User;

@UseCase
@RequiredArgsConstructor
public class GetUserService implements GetUserUseCase {
    private final GetUserPort getUserPort;

    @Override
    public User getUser(Long userId) {
        return getUserPort.getUser(userId);
    }
}
