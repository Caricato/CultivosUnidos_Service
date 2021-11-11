package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.ExportSuppliesUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.ExportSuppliesPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.io.OutputStream;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ExportSuppliesService implements ExportSuppliesUseCase {
    private final ExportSuppliesPort exportSuppliesPort;

    @Override
    public void exportSupplies(List<Supply> supplies, OutputStream outputStream) {
        var data = fillReport(supplies);
        exportSuppliesPort.exportSupplies(data, outputStream, supplies.get(0).getCommunity().getCommunityName());
    }

    private String[][] fillReport(List<Supply> supplies){
        String[][] data = new String[supplies.size()][6];

        for (int i = 0; i < supplies.size(); i++) {
            data[i][0] = ((Integer)(i+1)).toString();
            data[i][1] = supplies.get(i).getSupplyName();
            data[i][2] = supplies.get(i).getStock().toString();
            data[i][3] = supplies.get(i).getUnitPricing().toString();
            data[i][4] = supplies.get(i).getStockMin().toString();
            data[i][5] = supplies.get(i).getSupplyMetricType().getName();
        }
        return data;
    }
}
