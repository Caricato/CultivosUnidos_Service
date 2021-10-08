package org.sistema.arroz.riceservice.modules.users.application.port.in;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserToRegister {
    String username;
}
