package org.sistema.arroz.riceservice.modules.token.application.port.in;

public interface GenerateChangePasswordTokenUseCase {
    String generateChangePassword(String username, String email);
}
