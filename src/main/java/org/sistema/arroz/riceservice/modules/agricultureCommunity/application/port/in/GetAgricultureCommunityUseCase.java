package org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

public interface GetAgricultureCommunityUseCase {
    AgricultureCommunity findCommunityById(Long communityId);
}
