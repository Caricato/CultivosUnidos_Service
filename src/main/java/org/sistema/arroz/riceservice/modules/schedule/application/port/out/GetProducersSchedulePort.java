package org.sistema.arroz.riceservice.modules.schedule.application.port.out;

import org.sistema.arroz.riceservice.modules.schedule.domain.InfoScheduleProducer;

import java.util.List;

public interface GetProducersSchedulePort {
    List<InfoScheduleProducer> getInfoScheduleProducers(Long communityId);
}
