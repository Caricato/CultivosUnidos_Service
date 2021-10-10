package org.sistema.arroz.riceservice.modules.users.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.users.domain.UserRole;

@Data
@Builder
public class UserToRegister {
    String username;
    UserRole role;
}
