package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.GetSuppliesFormulasPort;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.RegisterSuppliesFormulasPort;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.SupplyFormulaToPersist;
import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class SupplyFormulaPersistenceAdapter implements RegisterSuppliesFormulasPort, GetSuppliesFormulasPort {
    private final SupplyFormulaMapper supplyFormulaMapper;
    private final SpringJpaSupplyFormulaRepository springJpaSupplyFormulaRepository;

    @Override
    public List<SupplyFormula> registerSuppliesFormulas(List<SupplyFormulaToPersist> suppliesFormulas) {
        var entities = supplyFormulaMapper.toSuppliesFormulasJpa(suppliesFormulas);
        var result = springJpaSupplyFormulaRepository.saveAll(entities);
        return supplyFormulaMapper.toSuppliesFormulas(result);
    }

    @Override
    public List<SupplyFormula> getSuppliesFormulas(Long productId) {
        var result = springJpaSupplyFormulaRepository.findAllByProduct_ProductId(productId);
        return supplyFormulaMapper.toSuppliesFormulas(result);
    }
}
