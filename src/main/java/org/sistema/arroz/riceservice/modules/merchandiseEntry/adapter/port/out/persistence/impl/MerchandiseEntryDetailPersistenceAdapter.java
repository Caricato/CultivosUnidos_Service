package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers.MerchandiseEntryDetailMapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.repositories.SpringJpaMerchandiseEntryDetailRepository;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.MerchandiseEntryDetailToPersist;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.RegisterMerchandiseEntryDetailsPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryDetail;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class MerchandiseEntryDetailPersistenceAdapter implements RegisterMerchandiseEntryDetailsPort {
    private final SpringJpaMerchandiseEntryDetailRepository entryDetailRepository;
    private final MerchandiseEntryDetailMapper entryDetailMapper;

    @Override
    public List<MerchandiseEntryDetail> registerMerchandiseEntryDetails(List<MerchandiseEntryDetailToPersist> details) {
        var entities = entryDetailMapper.toMerchandiseEntriesDetailJpa(details);
        var result = entryDetailRepository.saveAll(entities);
        return entryDetailMapper.toMerchandiseEntriesDetail(result);
    }
}
