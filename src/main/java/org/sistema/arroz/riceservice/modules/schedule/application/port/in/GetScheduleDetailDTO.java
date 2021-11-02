package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetScheduleDetailDTO {
    Long scheduleDetailId;
    String producerName;
    String producerDNI;
    Double producerHectares;
    Boolean isFreeHectares;
}
