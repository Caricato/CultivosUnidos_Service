package org.sistema.arroz.riceservice.hexagonal.queries;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Filters {
    private Integer page;
    private Integer pageSize;
    private String search;
}

