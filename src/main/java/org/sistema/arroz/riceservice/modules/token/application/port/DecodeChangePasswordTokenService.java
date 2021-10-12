package org.sistema.arroz.riceservice.modules.token.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.helpers.JwtHelper;
import org.sistema.arroz.riceservice.modules.token.application.port.in.DecodeChangePasswordTokenUseCase;
import org.sistema.arroz.riceservice.modules.token.domain.ChangePasswordTokenBody;
import org.sistema.arroz.riceservice.modules.token.domain.InvalidTokenException;

@UseCase
@RequiredArgsConstructor
public class DecodeChangePasswordTokenService implements DecodeChangePasswordTokenUseCase {
    private final JwtHelper jwtHelper;

    @Override
    public ChangePasswordTokenBody decodeChangePasswordToken(String token) {
        try {
            var claims = jwtHelper.decode(token);
            var email = claims.get("email", String.class);
            var username = claims.getSubject();

            return new ChangePasswordTokenBody(email, username);

        } catch (Exception exception) {
            throw new InvalidTokenException();
        }
    }
}
