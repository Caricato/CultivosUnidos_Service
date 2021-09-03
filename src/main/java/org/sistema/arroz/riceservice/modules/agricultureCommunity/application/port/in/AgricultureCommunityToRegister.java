package org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgricultureCommunityToRegister {
    String communityName;
}
