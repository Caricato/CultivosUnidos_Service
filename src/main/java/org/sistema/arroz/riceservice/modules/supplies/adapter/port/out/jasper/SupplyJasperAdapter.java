package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.jasper;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.reports.ReportDownloader;
import org.sistema.arroz.riceservice.hexagonal.reports.Templates;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.ExportSuppliesPort;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.OutputStream;

@PersistenceAdapter
@RequiredArgsConstructor
public class SupplyJasperAdapter implements ExportSuppliesPort {
    @Override
    public void exportSupplies(String[][] data, OutputStream outputStream, String communityName) {
        var tableModel = new DefaultTableModel(data, new String [6]);
        try {
            ReportDownloader.downloadPDF(outputStream, Templates.TEMPLATE_INFO_SUPPLIES, "REPORTE DE INSUMOS", communityName, tableModel, data.length);
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }
}
