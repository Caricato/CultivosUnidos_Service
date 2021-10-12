package org.sistema.arroz.riceservice.modules.users.application.port.in;

public interface GeneratePasswordUseCase {
    void generatePassword(String token, String password);
}
