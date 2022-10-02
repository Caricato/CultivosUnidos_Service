package org.sistema.arroz.riceservice.modules.agricultureCommunity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.supervisor.domain.Supervisor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgricultureCommunity {
    Long communityId;
    String communityName;
    Supervisor supervisor;
}
