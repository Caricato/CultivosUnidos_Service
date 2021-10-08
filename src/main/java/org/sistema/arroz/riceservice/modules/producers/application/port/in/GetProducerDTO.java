package org.sistema.arroz.riceservice.modules.producers.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProducerDTO {
    Long producerId;
    String producerName;
    String producerFirstLastName;
    String producerSecondLastName;
    String dni;
    String email;
    String address;
    Double hectares;
    String fullName;
}
