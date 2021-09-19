package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import lombok.Builder;
import lombok.Data;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;

import java.util.List;

@Builder
@Data
public class MerchandiseEntryDTO {
    MerchandiseFlow merchandiseFlow;
    List<MerchandiseFlowDetail> details;
}
