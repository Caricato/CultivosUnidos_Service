package org.sistema.arroz.riceservice.hexagonal.queries.dates;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RangeDatesDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate endDate;
}
