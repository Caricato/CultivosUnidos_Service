package org.sistema.arroz.riceservice.modules.producers.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.LocalDateTimePeruZone;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.ProducerToRegister;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.GetProducerPort;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.GetProducersPort;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.RegisterProducerPort;
import org.sistema.arroz.riceservice.modules.producers.application.port.out.ValidateProducerToRegisterPort;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.sistema.arroz.riceservice.modules.producers.domain.ProducerNotFoundException;
import org.sistema.arroz.riceservice.modules.users.adapter.port.out.persistence.UserMapper;
import org.sistema.arroz.riceservice.modules.users.domain.User;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProducerPersistenceAdapter implements ValidateProducerToRegisterPort, RegisterProducerPort, GetProducersPort, GetProducerPort {
    private final ProducerMapper producerMapper;
    private final AgricultureCommunityMapper communityMapper;
    private final UserMapper userMapper;
    private final SpringJpaProducerRepository producerRepository;

    @Override
    public Optional<Producer> validateProducer(String dni) {
        var result = producerRepository.findByDni(dni);
        return result.map(producerMapper::toProducer);
    }

    @Override
    public Producer registerProducer(AgricultureCommunity community, User user, ProducerToRegister producerToRegister) {
        var producer = producerMapper.toProducerJpa(producerToRegister);
        producer.setCommunity(communityMapper.toAgricultureCommunityJpaEntity(community));
        producer.setUser(userMapper.toUserJpa(user));
        producer.setInscriptionDate(LocalDateTimePeruZone.now());
        var result = producerRepository.save(producer);
        return producerMapper.toProducer(result);
    }

    @Override
    public List<Producer> getProducers(Long communityId) {
        var entities = producerRepository.findAllByCommunity_CommunityIdAndUser_State(communityId, true);
        return producerMapper.toProducers(entities);
    }

    @Override
    public Producer getProducer(Long producerId) {
        var entity = producerRepository.findById(producerId);
        if (entity.isEmpty()) throw new ProducerNotFoundException(producerId);
        return producerMapper.toProducer(entity.get());
    }

    @Override
    public Producer getProducerByUser(Long userId) {
        return null;
    }
}
