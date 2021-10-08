package org.sistema.arroz.riceservice.modules.users.application.port.out;

import org.sistema.arroz.riceservice.modules.users.application.port.in.UserToRegister;
import org.sistema.arroz.riceservice.modules.users.domain.User;

public interface RegisterUserPort {
    User registerUser(UserToRegister  userToRegister);
}
