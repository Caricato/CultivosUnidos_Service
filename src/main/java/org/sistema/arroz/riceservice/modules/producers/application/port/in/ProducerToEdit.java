package org.sistema.arroz.riceservice.modules.producers.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProducerToEdit {
    String email;
    String address;
    Double hectares;
}
