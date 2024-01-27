package org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.GetAgricultureCommunityUseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunityNotFoundException;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunitySupervisorException;

@UseCase
@Slf4j
@RequiredArgsConstructor
public class GetAgricultureCommunityService implements GetAgricultureCommunityUseCase {
    private final GetAgricultureCommunityPort findAgricultureCommunityPort;

    @Override
    public AgricultureCommunity findCommunityById(Long communityId) {
        var result = findAgricultureCommunityPort.findCommunityById(communityId);
        if (result == null) {
            log.debug("Agriculture Community not found");
            throw new AgricultureCommunityNotFoundException(communityId);
        }
        return result;
    }

    @Override
    public AgricultureCommunity findCommunityBySupervisorDNI(String dni) {
        var result = findAgricultureCommunityPort.findCommunityBySupervisorDNI(dni);
        if (result == null) throw new AgricultureCommunitySupervisorException(dni);
        return result;
    }
}
