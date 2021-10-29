package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleToRegister {
    Long productId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate startDate;
    Integer cantProducers;
    Double hectares;
    ScheduleType scheduleType;
}
