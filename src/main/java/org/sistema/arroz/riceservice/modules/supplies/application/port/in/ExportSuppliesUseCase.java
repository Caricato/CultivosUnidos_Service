package org.sistema.arroz.riceservice.modules.supplies.application.port.in;

import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.io.OutputStream;
import java.util.List;

public interface ExportSuppliesUseCase {
    void exportSupplies(List<Supply> supplies, OutputStream outputStream);
}
