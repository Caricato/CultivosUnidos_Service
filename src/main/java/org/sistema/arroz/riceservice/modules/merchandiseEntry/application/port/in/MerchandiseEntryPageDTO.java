package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;

@Builder
@Data
public class MerchandiseEntryPageDTO {
    MerchandiseFlow merchandiseFlow;
    Paginator<MerchandiseFlowDetail> detailPage;
}
