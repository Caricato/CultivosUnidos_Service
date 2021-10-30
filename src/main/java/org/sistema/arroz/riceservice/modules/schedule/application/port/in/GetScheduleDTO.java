package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetScheduleDTO {
    Long scheduleId;
    LocalDate startDate;
    Double hectares;
    String state;
    String productName;
}
