package org.sistema.arroz.riceservice.modules.supplyFormula.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.ExportBudgetUseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.ExportBudgetPort;
import org.sistema.arroz.riceservice.modules.products.application.port.out.GetProductPort;
import org.sistema.arroz.riceservice.modules.products.domain.ProductNotFoundException;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetBudgetDTO;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesBudgetDTO;

import java.io.OutputStream;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ExportBudgetService implements ExportBudgetUseCase {
    private final ExportBudgetPort exportBudgetPort;
    private final GetProductPort getProductPort;

    @Override
    public void exportBudget(Long productId, Double hectares, GetBudgetDTO budgetDTO, OutputStream outputStream) {
        var data = fillReport(budgetDTO.getSupplies());
        var product = getProductPort.getProductById(productId);
        if (product.isEmpty()) throw new ProductNotFoundException(productId);
        exportBudgetPort.exportBudget(data,
                outputStream, product.get().getCommunity().getCommunityName(),
                product.get().getProductName(), hectares.toString(), formatNumber(budgetDTO.getTotal()));
    }

    private String[][] fillReport(List<GetSuppliesBudgetDTO> supplies){
        String[][] data = new String[supplies.size()][6];

        for (int i = 0; i < supplies.size(); i++) {
            data[i][0] = ((Integer)(i+1)).toString();
            data[i][1] = supplies.get(i).getSupplyName();
            data[i][2] = supplies.get(i).getTotalCant().toString();
            data[i][3] = supplies.get(i).getMetricType().toString();
            data[i][4] = formatNumber(supplies.get(i).getUnitPricing());
            data[i][5] = formatNumber(supplies.get(i).getSubtotal());
        }
        return data;
    }

    private String formatNumber(Double number){
        return "S/. "+String.format("%,.2f", number);
    }
}
