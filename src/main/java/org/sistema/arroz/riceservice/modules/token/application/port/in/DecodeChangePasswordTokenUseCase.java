package org.sistema.arroz.riceservice.modules.token.application.port.in;

import org.sistema.arroz.riceservice.modules.token.domain.ChangePasswordTokenBody;

public interface DecodeChangePasswordTokenUseCase {
    ChangePasswordTokenBody decodeChangePasswordToken(String token);
}
