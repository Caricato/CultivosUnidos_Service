package org.sistema.arroz.riceservice.hexagonal.reports;

import javax.swing.table.DefaultTableModel;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.io.OutputStream;
import java.util.HashMap;


public class ReportDownloader{
    public static void downloadPDF(OutputStream outputStream,
                            String reportUrl, String filename, String communityName, DefaultTableModel tableModel, Integer cant)
            throws JRException, IOException {
        var parameters = new HashMap();
        parameters.put("Title", filename);
        parameters.put("Cant", cant);
        parameters.put("NombreComunidad", communityName);
        InputStream in = new URL(reportUrl).openStream();
        JasperReport jasperReport = JasperCompileManager.compileReport(in);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,new JRTableModelDataSource(tableModel));
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }

}
