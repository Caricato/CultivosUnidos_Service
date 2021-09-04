package org.sistema.arroz.riceservice.modules.supplies.application.port.out;

import java.io.OutputStream;

public interface ExportSuppliesPort {
    void exportSupplies(String[][] data, OutputStream outputStream, String communityName);
}
