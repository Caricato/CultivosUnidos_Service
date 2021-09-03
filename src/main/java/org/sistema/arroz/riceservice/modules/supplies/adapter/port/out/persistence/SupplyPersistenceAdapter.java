package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToEdit;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToRegister;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.DeleteSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.EditSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetSuppliesPort;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.RegisterSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyNotFoundException;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyStockInconsistencyException;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class SupplyPersistenceAdapter implements RegisterSupplyPort, EditSupplyPort, DeleteSupplyPort, GetSuppliesPort {

    private final SpringJpaSupplyRepository springJpaSupplyRepository;
    private final SupplyMapper supplyMapper;
    private final AgricultureCommunityMapper agricultureCommunityMapper;

    @Override
    public Supply registerSupply(SupplyToRegister supplyToRegister, AgricultureCommunity agricultureCommunity) {
        var supplyJpa = supplyMapper.toSupplyJpaEntity(supplyToRegister);
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
        supplyJpaEntity.setSupplyMetricType(supplyToEdit.getSupplyMetricType().getValue());

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
        return supplyId;
    }

    @Override
    public List<Supply> getSupplies(Long communityId) {
        var suppliesJpa = springJpaSupplyRepository.findAllByCommunityJpaEntity_CommunityIdAndStateOrderBySupplyName(communityId, true);
        return supplyMapper.toSupplies(suppliesJpa);
    }
}