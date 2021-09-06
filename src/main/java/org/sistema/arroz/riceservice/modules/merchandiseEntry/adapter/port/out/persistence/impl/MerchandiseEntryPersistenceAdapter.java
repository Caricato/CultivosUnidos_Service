package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers.MerchandiseEntryMapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.repositories.SpringJpaMerchandiseEntryRepository;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.RegisterMerchandiseEntryPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;

@PersistenceAdapter
@RequiredArgsConstructor
public class MerchandiseEntryPersistenceAdapter implements RegisterMerchandiseEntryPort {
    private final SpringJpaMerchandiseEntryRepository merchandiseEntryRepository;
    private final MerchandiseEntryMapper merchandiseEntryMapper;
    private final AgricultureCommunityMapper agricultureCommunityMapper;

    @Override
    public MerchandiseEntry registerMerchandiseEntry(MerchandiseEntryToRegister merchandiseEntryToRegister, AgricultureCommunity community) {
        var entity = merchandiseEntryMapper.toMerchandiseEntryJpa(merchandiseEntryToRegister);
        entity.setCommunity(agricultureCommunityMapper.toAgricultureCommunityJpaEntity(community));

        var result = merchandiseEntryRepository.save(entity);
        return merchandiseEntryMapper.toMerchandiseEntry(result);
    }
}
