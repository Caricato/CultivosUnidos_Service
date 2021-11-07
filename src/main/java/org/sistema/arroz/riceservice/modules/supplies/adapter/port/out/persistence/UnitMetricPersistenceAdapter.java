package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.UnitMetricToEdit;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.UnitMetricToRegister;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.DeleteUnitMetricPort;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.EditUnitMetricPort;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetUnitMetricsPort;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.RegisterUnitMetricPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetricNotFoundException;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class UnitMetricPersistenceAdapter implements GetUnitMetricsPort, DeleteUnitMetricPort, RegisterUnitMetricPort, EditUnitMetricPort {
    private final UnitMetricMapper unitMetricMapper;
    private final AgricultureCommunityMapper communityMapper;
    private final SpringJpaUnitMetricRepository unitMetricRepository;

    @Override
    public List<UnitMetric> getActiveUnitMetrics(Long communityId) {
        var entitiesJpa = unitMetricRepository.findAllByCommunity_CommunityIdAndState(communityId, true);
        return unitMetricMapper.toUnitMetrics(entitiesJpa);
    }

    @Override
    public void deleteUnitMetric(Long unitMetricId) {
        var entity = unitMetricRepository.findById(unitMetricId);
        if (entity.isEmpty()) throw new UnitMetricNotFoundException(unitMetricId);
        entity.get().setState(false);
        unitMetricRepository.save(entity.get());
    }

    @Override
    public UnitMetric editUnitMetric(Long unitMetricId, UnitMetricToEdit unitMetricToEdit) {
        var entity = unitMetricRepository.findById(unitMetricId);
        if (entity.isEmpty()) throw new UnitMetricNotFoundException(unitMetricId);
        entity.get().setName(unitMetricToEdit.getName());
        var result = unitMetricRepository.save(entity.get());
        return unitMetricMapper.toUnitMetric(result);
    }

    @Override
    public UnitMetric registerUnitMetric(UnitMetricToRegister unitMetricToRegister, AgricultureCommunity community) {
        var entityJpa = unitMetricMapper.toUnitMetricJpa(unitMetricToRegister);
        entityJpa.setCommunity(communityMapper.toAgricultureCommunityJpaEntity(community));
        entityJpa.setState(true);
        var result = unitMetricRepository.save(entityJpa);
        return unitMetricMapper.toUnitMetric(result);
    }
}
