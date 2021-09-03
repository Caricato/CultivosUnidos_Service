package org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.AgricultureCommunityToRegister;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

public interface RegisterAgricultureCommunityPort {
    AgricultureCommunity registerAgricultureCommunity(AgricultureCommunityToRegister agricultureCommunityToRegister);
}
