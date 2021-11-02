package org.sistema.arroz.riceservice.modules.parameters.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleParametersToRegister {
    String key;
    Integer value;
}
