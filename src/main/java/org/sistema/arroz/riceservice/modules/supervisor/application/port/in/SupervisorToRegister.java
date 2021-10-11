package org.sistema.arroz.riceservice.modules.supervisor.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupervisorToRegister {
    String dni;
    String supervisorName;
    String supervisorFirstLastName;
    String supervisorSecondLastName;
    String email;
}
