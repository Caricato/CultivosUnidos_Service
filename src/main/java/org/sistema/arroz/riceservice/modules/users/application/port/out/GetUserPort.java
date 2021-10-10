package org.sistema.arroz.riceservice.modules.users.application.port.out;

import org.sistema.arroz.riceservice.modules.users.domain.User;

public interface GetUserPort {
    User getUser(Long userId);
    User getUser(String username);
}
