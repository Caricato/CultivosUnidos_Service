package org.sistema.arroz.riceservice.modules.users.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.helpers.PasswordHelper;
import org.sistema.arroz.riceservice.modules.token.application.port.in.DecodeChangePasswordTokenUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GeneratePasswordUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GetUserUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.out.GeneratePasswordPort;

@UseCase
@RequiredArgsConstructor
public class GeneratePasswordService implements GeneratePasswordUseCase {
    private final GeneratePasswordPort generatePasswordPort;
    private final PasswordHelper passwordHelper;
    private final DecodeChangePasswordTokenUseCase decodeChangePasswordTokenUseCase;

    @Override
    public void generatePassword(String token, String password) {
        var tokenBody = decodeChangePasswordTokenUseCase.decodeChangePasswordToken(token);
        generatePasswordPort.generatePassword(tokenBody.getUsername(), passwordHelper.generateHashedPassword(password));
    }
}
