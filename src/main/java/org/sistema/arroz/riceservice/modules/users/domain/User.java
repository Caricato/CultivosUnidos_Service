package org.sistema.arroz.riceservice.modules.users.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    Long userId;
    String userName;
    String password;
    Boolean state;
    Boolean passwordReset;
    Boolean passwordFirstTime;
}
