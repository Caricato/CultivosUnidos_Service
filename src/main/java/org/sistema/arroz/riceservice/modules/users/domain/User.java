package org.sistema.arroz.riceservice.modules.users.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Long userId;
    String username;
    String password;
    Boolean state;
    Boolean passwordReset;
    Boolean passwordFirstTime;
}
