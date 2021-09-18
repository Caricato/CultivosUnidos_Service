package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in;

import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetBudgetDTO;

import java.io.OutputStream;

public interface ExportBudgetUseCase {
    void exportBudget(Long productId, Double hectares, GetBudgetDTO productDetailDTO, OutputStream outputStream);
}
