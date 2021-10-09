package org.sistema.arroz.riceservice.modules.users.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.helpers.PasswordHelper;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GeneratePasswordUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GetUserUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.out.GeneratePasswordPort;

@UseCase
@RequiredArgsConstructor
public class GeneratePasswordService implements GeneratePasswordUseCase {
    private final GeneratePasswordPort generatePasswordPort;
    private final PasswordHelper passwordHelper;
    private final GetUserUseCase getUserUseCase;

    @Override
    public void generatePassword(Long userId, String password) {
        generatePasswordPort.generatePassword(userId, passwordHelper.generateHashedPassword(password));
    }
}
