package org.sistema.arroz.riceservice.modules.statistics.application.port.in;

import org.sistema.arroz.riceservice.hexagonal.queries.dates.RangeDatesDTO;


public interface GetMonthlyReportUseCase {
    GetMonthlyReportDTO getMonthlyReport(Long communityId, RangeDatesDTO rangeDatesDTO);
}
