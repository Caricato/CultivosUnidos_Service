package org.sistema.arroz.riceservice.modules.producers.adapter.port.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringJpaProducerRepository extends JpaRepository<ProducerJpaEntity, Long> {
    Optional<ProducerJpaEntity> findByDni(String dni);
    Optional<ProducerJpaEntity> findByEmail(String email);
    Optional<ProducerJpaEntity> findByEmailAndProducerIdNot(String email, Long producerId);
    Optional<ProducerJpaEntity> findByPhone(String number);
    Optional<ProducerJpaEntity> findByPhoneAndProducerIdNot(String number, Long producerId);
    List<ProducerJpaEntity> findAllByCommunity_CommunityIdAndUser_StateOrderByProducerFirstLastName(Long communityId, Boolean state);
    List<ProducerJpaEntity> findAllByCommunity_CommunityIdAndUser_StateOrderByHectaresDesc(Long communityId, Boolean state);
}
