package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseEntryDetailToPersist {
    MerchandiseFlow merchandiseFlow;
    Supply supply;
    Double entryCant;
}
