package org.sistema.arroz.riceservice.modules.users.application.port.in;

import org.sistema.arroz.riceservice.modules.users.domain.User;

public interface GetUserUseCase {
    User getUser(Long userId);
}
