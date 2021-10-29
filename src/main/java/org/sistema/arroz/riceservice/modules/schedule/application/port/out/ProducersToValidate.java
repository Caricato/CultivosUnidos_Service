package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

@Data
@Builder
public class ProducersToValidate {
    Double freeHectares;
    Producer producer;
    Integer priority;
}
