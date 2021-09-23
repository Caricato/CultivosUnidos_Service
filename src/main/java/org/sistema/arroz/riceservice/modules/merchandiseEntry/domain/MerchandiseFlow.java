package org.sistema.arroz.riceservice.modules.merchandiseEntry.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseFlow {
    Long merchandiseEntryId;
    AgricultureCommunity community;
    LocalDateTime entryDate;
    MerchandiseFlowSubtype subtype;
    MerchandiseFlowType entryType;
    //TODO: Associate a producer
}
