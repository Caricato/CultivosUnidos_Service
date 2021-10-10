package org.sistema.arroz.riceservice.hexagonal.helpers;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.sistema.arroz.riceservice.hexagonal.HelperAdapter;


@HelperAdapter
@RequiredArgsConstructor
public class PasswordHelper {
    public String generateHashedPassword(String newPassword) {
        return BCrypt.hashpw(newPassword, BCrypt.gensalt());
    }

    public boolean areSamePasswords(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}

