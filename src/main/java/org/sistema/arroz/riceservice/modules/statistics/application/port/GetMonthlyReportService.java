package org.sistema.arroz.riceservice.modules.statistics.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.RangeDatesDTO;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.GetSaleDetailUseCase;
import org.sistema.arroz.riceservice.modules.sales.application.port.in.GetSalesUseCase;
import org.sistema.arroz.riceservice.modules.sales.domain.Sale;
import org.sistema.arroz.riceservice.modules.sales.domain.SaleDetail;
import org.sistema.arroz.riceservice.modules.statistics.application.port.in.GetMonthlyCantReportDTO;
import org.sistema.arroz.riceservice.modules.statistics.application.port.in.GetMonthlyReportDTO;
import org.sistema.arroz.riceservice.modules.statistics.application.port.in.GetMonthlyReportUseCase;
import org.sistema.arroz.riceservice.modules.statistics.application.port.in.GetSacksReportDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetMonthlyReportService implements GetMonthlyReportUseCase {
    private final GetSalesUseCase getSalesUseCase;
    private final GetSaleDetailUseCase getSaleDetailUseCase;

    @Override
    public GetMonthlyReportDTO getMonthlyReport(Long communityId, RangeDatesDTO rangeDatesDTO) {
        var cantReport = new ArrayList<GetMonthlyCantReportDTO>(3);
        var productsSacksMap = new HashMap<String, Integer>();
        var productsSubtotalMap = new HashMap<String, Double>();

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
            fillTotalMonth(sales, productsSacksMap, productsSubtotalMap, cantReport);
            categories.add(setFormatDate(iniAuxDate));
        }

        var products = new ArrayList<String>();
        var sacks = new ArrayList<Integer>();
        var subtotal = new ArrayList<Double>();
        for (var entry: productsSacksMap.entrySet()){
            products.add(entry.getKey());
            sacks.add(entry.getValue());
        }

        for (var entry: productsSubtotalMap.entrySet()){
            subtotal.add(entry.getValue());
        }
        var sacksReport = GetSacksReportDTO.builder().sacks(sacks).products(products).subtotal(subtotal).build();
        return GetMonthlyReportDTO.builder().cantReport(cantReport).categories(categories).sacksReportDTO(sacksReport).build();
    }

    private void fillTotalMonth(List<Sale> sales, HashMap<String, Integer> productsSacksMap, HashMap<String, Double> productsSubtotalMap, List<GetMonthlyCantReportDTO> cantReport){
        var total = 0.0;
        var theoretical = 0.0;
        for (var sale: sales){
            total+=sale.getSaleTotal();
            theoretical+=sale.getTheoreticalTotal();
            var saleDetails = getSaleDetailUseCase.getSaleDetail(sale.getSaleId());
            fillProductsMap(saleDetails, productsSacksMap, productsSubtotalMap);
        }

        var totalData = cantReport.get(0).getData();
        var theoreticalData = cantReport.get(1).getData();
        var indicatorData = cantReport.get(2).getData();
        totalData.add(total);
        theoreticalData.add(theoretical);
        if (theoretical != 0) indicatorData.add((Math.floor((total/theoretical)*100)/100)*100);
        else indicatorData.add(0.0);
        cantReport.get(0).setData(totalData);
        cantReport.get(1).setData(theoreticalData);
        cantReport.get(2).setData(indicatorData);
    }

    private void fillProductsMap(List<SaleDetail> details, HashMap<String, Integer> productsSacksMap, HashMap<String, Double> productsSubtotalMap){
        for (var detail: details){
            var productName = detail.getProduct().getProductName();
            if (!productsSacksMap.containsKey(productName)){
                productsSacksMap.put(productName, detail.getSoldSacks());
                productsSubtotalMap.put(productName, detail.getSubtotal());
            }
            else{
                productsSacksMap.put(productName, productsSacksMap.get(productName)+detail.getSoldSacks());
                productsSubtotalMap.put(productName, productsSacksMap.get(productName)+detail.getSubtotal());
            }
        }
    }

    private String setFormatDate(LocalDate localDate){
        return localDate.getMonthValue()+"/"+localDate.getYear();
    }
}
