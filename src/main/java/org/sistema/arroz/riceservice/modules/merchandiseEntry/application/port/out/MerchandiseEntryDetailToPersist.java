package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseEntryDetailToPersist {
    MerchandiseEntry merchandiseEntry;
    Supply supply;
    Integer entryCant;
}
