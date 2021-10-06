package org.sistema.arroz.riceservice.modules.statistics.application.port.in;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetSacksReportDTO {
    List<String> products;
    List<Integer> sacks;
    List<Double> subtotal;
}
