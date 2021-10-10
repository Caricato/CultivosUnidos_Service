package org.sistema.arroz.riceservice.modules.supervisor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.users.domain.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supervisor {
    Long supervisorId;
    String supervisorName;
    String supervisorFirstLastName;
    String supervisorSecondLastName;
    String dni;
    String email;
    User user;
}
