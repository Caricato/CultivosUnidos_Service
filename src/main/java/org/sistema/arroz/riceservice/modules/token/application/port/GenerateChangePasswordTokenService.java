package org.sistema.arroz.riceservice.modules.token.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.JwtConfig;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.helpers.JwtHelper;
import org.sistema.arroz.riceservice.modules.token.application.port.in.GenerateChangePasswordTokenUseCase;
import org.sistema.arroz.riceservice.modules.token.domain.ChangePasswordTokenBody;

@UseCase
@RequiredArgsConstructor
public class GenerateChangePasswordTokenService implements GenerateChangePasswordTokenUseCase {
    private final JwtConfig jwtConfig;
    private final JwtHelper jwtHelper;

    @Override
    public String generateChangePassword(String username, String email) {
        var expMinutes = 1440L;
        var claims = new ChangePasswordTokenBody(email, username).map();
        return jwtHelper.generateToken(username, claims, expMinutes);
    }
}
