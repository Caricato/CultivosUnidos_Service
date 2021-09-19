package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.impl;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.mappers.MerchandiseEntryDetailMapper;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.out.persistence.repositories.SpringJpaMerchandiseEntryDetailRepository;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.*;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowProductDetail;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class MerchandiseEntryDetailPersistenceAdapter implements RegisterMerchandiseEntryDetailsPort, GetMerchandiseEntryDetailsPort, RegisterProductDetailPort, GetMerchandiseProductDetailPort {
    private final SpringJpaMerchandiseEntryDetailRepository entryDetailRepository;
    private final MerchandiseEntryDetailMapper entryDetailMapper;

    @Override
    public List<MerchandiseFlowDetail> registerMerchandiseEntryDetails(List<MerchandiseEntryDetailToPersist> details) {
        var entities = entryDetailMapper.toMerchandiseEntriesDetailJpa(details);
        var result = entryDetailRepository.saveAll(entities);
        return entryDetailMapper.toMerchandiseEntriesDetail(result);
    }

    @Override
    public Paginator<MerchandiseFlowDetail> getMerchandiseEntryDetails(Filters filters, Long merchandiseEntryId) {
        var pageable = PageRequest.of(filters.getPage(), filters.getPageSize());
        var page = entryDetailRepository.findByMerchandiseFlow_MerchandiseFlowId(pageable, merchandiseEntryId);
        var data = page.getContent()
                .stream().map(entryDetailMapper::toMerchandiseEntryDetail)
                .collect(Collectors.toList());

        return Paginator.<MerchandiseFlowDetail>builder()
                .page(filters.getPage())
                .pageSize(filters.getPageSize())
                .total(page.getTotalElements())
                .data(data)
                .build();
    }

    @Override
    public List<MerchandiseFlowDetail> registerProductDetails(List<MerchandiseProductDetailToPersist> details) {
        var entities = entryDetailMapper.toMerchandiseProductsDetailJpa(details);
        var result = entryDetailRepository.saveAll(entities);
        return entryDetailMapper.toMerchandiseEntriesDetail(result);
    }

    @Override
    public Paginator<MerchandiseFlowProductDetail> getMerchandiseProductDetails(Filters filters, Long merchandiseEntryId) {
        var pageable = PageRequest.of(filters.getPage(), filters.getPageSize());
        var page = entryDetailRepository.findByMerchandiseFlow_MerchandiseFlowId(pageable, merchandiseEntryId);
        var data = page.getContent()
                .stream().map(entryDetailMapper::toMerchandiseFlowProductDetail)
                .collect(Collectors.toList());

        return Paginator.<MerchandiseFlowProductDetail>builder()
                .page(filters.getPage())
                .pageSize(filters.getPageSize())
                .total(page.getTotalElements())
                .data(data)
                .build();
    }
}
