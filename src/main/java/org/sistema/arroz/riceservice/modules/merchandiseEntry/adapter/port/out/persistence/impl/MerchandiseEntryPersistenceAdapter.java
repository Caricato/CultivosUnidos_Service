package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.hexagonal.queries.dates.FiltersDate;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers.MerchandiseEntryMapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.repositories.SpringJpaMerchandiseEntryRepository;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.GetMerchandiseEntriesPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.RegisterMerchandiseEntryPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;
import org.springframework.data.domain.PageRequest;

import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class MerchandiseEntryPersistenceAdapter implements RegisterMerchandiseEntryPort, GetMerchandiseEntriesPort {
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

    @Override
    public Paginator<MerchandiseEntry> getMerchandiseEntries(FiltersDate filters, Long communityId) {
        var pageable = PageRequest.of(filters.getPage(), filters.getPageSize());
        var page = merchandiseEntryRepository.searchMerchandiseEntries(pageable, communityId, filters.getStartDate(), filters.getEndDate());
        var data = page.getContent()
                .stream().map(merchandiseEntryMapper::toMerchandiseEntry)
                .collect(Collectors.toList());

        return Paginator.<MerchandiseEntry>builder()
                .page(filters.getPage())
                .pageSize(filters.getPageSize())
                .total(page.getTotalElements())
                .data(data)
                .build();
    }
}
