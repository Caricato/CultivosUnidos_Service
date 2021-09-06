package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryDetail;

import java.util.List;

@Builder
@Data
public class MerchandiseEntryDTO {
    MerchandiseEntry merchandiseEntry;
    List<MerchandiseEntryDetail> details;
}
