package org.sistema.arroz.riceservice.modules.merchandiseEntry.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseFlowDetail {
    Long entryDetailId;
    MerchandiseFlow merchandiseFlow;
    Supply supply;
    Integer entryCant;
}
