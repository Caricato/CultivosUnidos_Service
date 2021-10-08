package org.sistema.arroz.riceservice.modules.producers.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProducerPersistenceAdapter {
    private final ProducerMapper producerMapper;
    private final SpringJpaProducerRepository producerRepository;
}
