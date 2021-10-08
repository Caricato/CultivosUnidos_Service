package org.sistema.arroz.riceservice.modules.producers.application.port.out;

import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

import java.util.List;

public interface GetProducersPort {
    List<Producer> getProducers(Long communityId);
}
