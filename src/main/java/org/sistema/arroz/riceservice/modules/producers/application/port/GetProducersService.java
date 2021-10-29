package org.sistema.arroz.riceservice.modules.producers.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.GetAgricultureCommunityUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducersUseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.GetProducersPort;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetProducersService implements GetProducersUseCase {
    private final GetProducersPort getProducersPort;
    private final GetAgricultureCommunityUseCase getAgricultureCommunityUseCase;

    @Override
    public List<Producer> getProducers(Long communityId) {
        getAgricultureCommunityUseCase.findCommunityById(communityId);
        return getProducersPort.getProducers(communityId);
    }

    @Override
    public List<Producer> getProducersForSchedule(Long communityId) {
        getAgricultureCommunityUseCase.findCommunityById(communityId);
        return getProducersPort.getProducersForSchedule(communityId);
    }
}
