package org.sistema.arroz.riceservice.modules.producers.application.port.in;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

import java.util.List;

public interface GetProducersUseCase {
    List<Producer> getProducers(Long communityId);
}
