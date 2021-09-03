package org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

public interface RegisterAgricultureCommunityUseCase {
    AgricultureCommunity registerAgricultureCommunity(AgricultureCommunityToRegister agricultureCommunityToRegister);
}
