package org.sistema.arroz.riceservice.modules.users.application.port.out;

public interface GeneratePasswordPort {
    void generatePassword(Long userId, String encryptedPassword);
}
