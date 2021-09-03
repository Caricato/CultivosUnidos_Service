package org.sistema.arroz.riceservice.modules.agricultureCommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AgricultureCommunity {
    Long communityId;
    String communityName;
}
