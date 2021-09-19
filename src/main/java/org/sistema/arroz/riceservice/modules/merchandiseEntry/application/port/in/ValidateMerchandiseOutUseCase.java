package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import java.util.List;

public interface ValidateMerchandiseOutUseCase {
    boolean validateMerchandiseOut(List<MerchandiseEntryDetailToRegister> details);
}
