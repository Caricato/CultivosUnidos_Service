package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;

@Getter
@AllArgsConstructor
public class MerchandiseEntryPageDTO {
    MerchandiseFlow merchandiseFlow;
}
