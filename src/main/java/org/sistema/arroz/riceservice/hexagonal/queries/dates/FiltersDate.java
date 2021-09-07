package org.sistema.arroz.riceservice.hexagonal.queries.dates;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FiltersDate {
    private Integer page;
    private Integer pageSize;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
