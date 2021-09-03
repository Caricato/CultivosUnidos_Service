package org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.AgricultureCommunityToRegister;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.RegisterAgricultureCommunityUseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.RegisterAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;

@UseCase
@RequiredArgsConstructor
public class RegisterAgricultureCommunityService implements RegisterAgricultureCommunityUseCase {
    private final RegisterAgricultureCommunityPort registerAgricultureCommunityPort;

    @Override
    public AgricultureCommunity registerAgricultureCommunity(AgricultureCommunityToRegister agricultureCommunityToRegister) {
        return registerAgricultureCommunityPort.registerAgricultureCommunity(agricultureCommunityToRegister);
    }
}
