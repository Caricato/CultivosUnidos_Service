package org.sistema.arroz.riceservice.modules.users.application.port.out;

public interface GeneratePasswordPort {
    void generatePassword(String username, String encryptedPassword);
}
