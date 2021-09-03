package org.sistema.arroz.riceservice.modules.supplies.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.out.persistence.AgricultureCommunityMapper;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToRegister;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.RegisterSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

@PersistenceAdapter
@RequiredArgsConstructor
public class SupplyPersistenceAdapter implements RegisterSupplyPort {

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
}