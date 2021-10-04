package org.sistema.arroz.riceservice.modules.statistics.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.RangeDatesDTO;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.GetSalesUseCase;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;
import org.sistema.arroz.riceservice.modules.statistics.application.port.in.GetMonthlyCantReportDTO;
import org.sistema.arroz.riceservice.modules.statistics.application.port.in.GetMonthlyReportDTO;
import org.sistema.arroz.riceservice.modules.statistics.application.port.in.GetMonthlyReportUseCase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetMonthlyReportService implements GetMonthlyReportUseCase {
    private final GetSalesUseCase getSalesUseCase;

    @Override
    public GetMonthlyReportDTO getMonthlyReport(Long communityId, RangeDatesDTO rangeDatesDTO) {
        var cantReport = new ArrayList<GetMonthlyCantReportDTO>(3);

        cantReport.add(GetMonthlyCantReportDTO.builder().data(new ArrayList<>()).build());
        cantReport.add(GetMonthlyCantReportDTO.builder().data(new ArrayList<>()).build());
        cantReport.add(GetMonthlyCantReportDTO.builder().data(new ArrayList<>()).build());

        var startDate = rangeDatesDTO.getStartDate();
        var endDate = rangeDatesDTO.getEndDate();
        var cantMonths = (endDate.getMonthValue()+12*(endDate.getYear()-startDate.getYear()))-startDate.getMonthValue()+1;
        var categories = new ArrayList<String>(cantMonths);
        for (var i = 0; i < cantMonths; i++){
            var iniAuxDate = startDate.plusMonths(i);
            if (i != 0) iniAuxDate = iniAuxDate.withDayOfMonth(1);
            var endAuxDate = startDate.plusMonths(i);
            endAuxDate = endAuxDate.withDayOfMonth(endAuxDate.lengthOfMonth());
            var sales = getSalesUseCase.getSales(communityId, RangeDatesDTO.builder().startDate(iniAuxDate).endDate(endAuxDate).build());
            fillTotalMonth(sales, i, cantReport);
            categories.add(setFormatDate(iniAuxDate));
        }

        return GetMonthlyReportDTO.builder().cantReport(cantReport).categories(categories).build();
    }

    private void fillTotalMonth(List<Sale> sales, Integer index, List<GetMonthlyCantReportDTO> cantReport){
        var total = 0.0;
        var theoretical = 0.0;
        for (var sale: sales){
            total+=sale.getSaleTotal();
            theoretical+=sale.getTheoreticalTotal();
        }

        var totalData = cantReport.get(0).getData();
        var theoreticalData = cantReport.get(1).getData();
        var indicatorData = cantReport.get(2).getData();
        totalData.add(total);
        theoreticalData.add(theoretical);
        if (theoretical != 0) indicatorData.add(Math.floor((total/theoretical)*100)/100);
        else indicatorData.add(0.0);
        cantReport.get(0).setData(totalData);
        cantReport.get(1).setData(theoreticalData);
        cantReport.get(2).setData(indicatorData);
    }

    private String setFormatDate(LocalDate localDate){
        return localDate.getMonthValue()+"/"+localDate.getYear();
    }
}
