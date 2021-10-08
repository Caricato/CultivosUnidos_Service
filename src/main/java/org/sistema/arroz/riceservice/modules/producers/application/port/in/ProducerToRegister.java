package org.sistema.arroz.riceservice.modules.producers.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProducerToRegister {
    String dni;
    String producerName;
    String producerFirstLastName;
    String producerSecondLastName;
    String email;
    String address;
    Double hectares;
}
