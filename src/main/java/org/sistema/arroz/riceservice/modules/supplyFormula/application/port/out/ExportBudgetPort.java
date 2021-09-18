package org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out;

import java.io.OutputStream;

public interface ExportBudgetPort {
    void exportBudget(String[][] data, OutputStream outputStream, String communityName, String productName, String hectares, String total);
}
