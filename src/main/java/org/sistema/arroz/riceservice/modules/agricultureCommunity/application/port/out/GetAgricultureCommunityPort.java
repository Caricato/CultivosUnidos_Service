package org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

public interface GetAgricultureCommunityPort {
    AgricultureCommunity findCommunityById(Long communityId);
}
