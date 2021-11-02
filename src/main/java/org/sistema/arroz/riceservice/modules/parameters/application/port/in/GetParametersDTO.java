package org.sistema.arroz.riceservice.modules.parameters.application.port.in;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetParametersDTO {
    String key;
    String value;
}
