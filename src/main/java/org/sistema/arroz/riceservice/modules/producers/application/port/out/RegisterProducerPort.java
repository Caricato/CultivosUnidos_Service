package org.sistema.arroz.riceservice.modules.producers.application.port.out;

import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToRegister;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.sistema.arroz.riceservice.modules.users.domain.User;

public interface RegisterProducerPort {
    Producer registerProducer(AgricultureCommunity community, User user, ProducerToRegister producerToRegister);
}
