package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryDetail;

@Builder
@Data
public class MerchandiseEntryPageDTO {
    MerchandiseEntry merchandiseEntry;
    Paginator<MerchandiseEntryDetail> detailPage;
}
