package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.products.domain.Product;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    Long scheduleId;
    LocalDate startDate;
    LocalDate endDate;
    Double hectares;
    ScheduleType state;
    Product product;
}
