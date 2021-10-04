package org.sistema.arroz.riceservice.modules.statistics.application.port.in;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetMonthlyCantReportDTO {
    List<Double> data;
}
