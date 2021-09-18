package org.sistema.arroz.riceservice.modules.products.adapter.port.out.jasper;

import net.sf.jasperreports.engine.JRException;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.reports.ReportDownloader;
import org.sistema.arroz.riceservice.hexagonal.reports.Templates;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.ExportBudgetPort;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.OutputStream;

@PersistenceAdapter
public class ProductJasperAdapter implements ExportBudgetPort {
    @Override
    public void exportBudget(String[][] data, OutputStream outputStream, String communityName, String productName, String hectares, String total) {
        var tableModel = new DefaultTableModel(data, new String [6]);
        try {
            ReportDownloader.downloadBudgetPDF(outputStream, Templates.TEMPLATE_INFO_BUDGET, "PRESUPUESTO DE COMPRA",
                    communityName, productName, hectares, total, tableModel, data.length);
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }
}
