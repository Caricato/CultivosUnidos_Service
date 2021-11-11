package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToEdit;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToRegister;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.*;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyNotFoundException;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyStockInconsistencyException;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetricNotFoundException;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@PersistenceAdapter
@RequiredArgsConstructor
public class SupplyPersistenceAdapter implements RegisterSupplyPort, EditSupplyPort, DeleteSupplyPort, GetSuppliesPort, GetAllSuppliesPort, GetSupplyPort, UpdateSupplyStockPort {

    private final SpringJpaSupplyRepository springJpaSupplyRepository;
    private final SupplyMapper supplyMapper;
    private final AgricultureCommunityMapper agricultureCommunityMapper;
    private final SpringJpaUnitMetricRepository unitMetricRepository;
    private final UnitMetricMapper unitMetricMapper;

    @Override
    public Supply registerSupply(SupplyToRegister supplyToRegister, AgricultureCommunity agricultureCommunity) {
        var supplyJpa = supplyMapper.toSupplyJpaEntity(supplyToRegister);

        var unitMetric = unitMetricRepository.findById(supplyToRegister.getSupplyMetricType());
        if (unitMetric.isEmpty()) throw new UnitMetricNotFoundException(supplyToRegister.getSupplyMetricType());
        supplyJpa.setUnitMetric(unitMetricMapper.toUnitMetricJpa(unitMetric.get()));
        supplyJpa.setCommunityJpaEntity(agricultureCommunityMapper.toAgricultureCommunityJpaEntity(agricultureCommunity));
        supplyJpa.setState(true);
        var result = springJpaSupplyRepository.save(supplyJpa);
        return supplyMapper.toSupply(result);
    }

    @Override
    public Supply editSupply(SupplyToEdit supplyToEdit, Long supplyId) {
        var supplyOptionalJpa = springJpaSupplyRepository.findById(supplyId);
        if (supplyOptionalJpa.isEmpty()) throw new SupplyNotFoundException(supplyId);
        var supplyJpaEntity = supplyOptionalJpa.get();
        supplyJpaEntity.setSupplyName(supplyToEdit.getSupplyName());
        supplyJpaEntity.setStockMin(supplyToEdit.getStockMin());
        supplyJpaEntity.setUnitPricing(supplyToEdit.getUnitPricing());
        var unitMetric = unitMetricRepository.findById(supplyToEdit.getSupplyMetricType());
        if (unitMetric.isEmpty()) throw new UnitMetricNotFoundException(supplyToEdit.getSupplyMetricType());
        supplyJpaEntity.setUnitMetric(unitMetricMapper.toUnitMetricJpa(unitMetric.get()));

        if (supplyJpaEntity.getStock() < supplyJpaEntity.getStockMin())
            throw new SupplyStockInconsistencyException(supplyJpaEntity.getStock(), supplyJpaEntity.getStockMin());

        var result = springJpaSupplyRepository.save(supplyJpaEntity);
        return supplyMapper.toSupply(result);
    }

    @Override
    public Long deleteSupply(Long supplyId) {
        var supplyOptionalJpa = springJpaSupplyRepository.findById(supplyId);
        if (supplyOptionalJpa.isEmpty()) throw new SupplyNotFoundException(supplyId);
        var supplyJpaEntity = supplyOptionalJpa.get();

        supplyJpaEntity.setState(false);
        springJpaSupplyRepository.save(supplyJpaEntity);
        return supplyId;
    }

    @Override
    public Paginator<Supply> getSupplies(Filters filters, Long communityId) {
        var pageable = PageRequest.of(filters.getPage(), filters.getPageSize());
        var page = springJpaSupplyRepository.searchSupplies(pageable, filters.getSearch(), communityId, true);
        var data = page.getContent()
                .stream().map(supplyMapper::toSupply)
                .collect(Collectors.toList());

        return Paginator.<Supply>builder()
                .page(filters.getPage())
                .pageSize(filters.getPageSize())
                .total(page.getTotalElements())
                .data(data)
                .build();
    }

    @Override
    public List<Supply> getAllSupplies(String search, Long communityId) {
        var entities = springJpaSupplyRepository.searchAllSupplies(search, communityId, true);
        return supplyMapper.toSupplies(entities);
    }

    @Override
    public Optional<Supply> getSupplyById(Long supplyId) {
        var result = springJpaSupplyRepository.findById(supplyId);
        return result.map(supplyMapper::toSupply);
    }

    @Override
    public Supply updateSupplyStock(Double newStock, Long supplyId) {
        var supplyJpa = springJpaSupplyRepository.findById(supplyId);
        if (supplyJpa.isEmpty()) throw new SupplyNotFoundException(supplyId);

        var supply = supplyJpa.get();
        supply.setStock(newStock);
        var result = springJpaSupplyRepository.save(supply);
        return supplyMapper.toSupply(result);
    }
}