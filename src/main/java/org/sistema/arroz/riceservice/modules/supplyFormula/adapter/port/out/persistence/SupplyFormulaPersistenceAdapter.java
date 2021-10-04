package org.sistema.arroz.riceservice.modules.supplyFormula.adapter.port.out.persistence;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.entities.ProductJpaEntity;
import org.sistema.arroz.riceservice.modules.products.adapter.port.out.persistence.mappers.ProductMapper;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.ValidateSupplyDeletionPort;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.GetSuppliesFormulasPort;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.RegisterSuppliesFormulasPort;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.SupplyFormulaToPersist;
import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class SupplyFormulaPersistenceAdapter implements RegisterSuppliesFormulasPort, GetSuppliesFormulasPort, ValidateSupplyDeletionPort {
    private final SupplyFormulaMapper supplyFormulaMapper;
    private final ProductMapper productMapper;
    private final SpringJpaSupplyFormulaRepository springJpaSupplyFormulaRepository;

    @Transactional
    @Override
    public List<SupplyFormula> registerSuppliesFormulas(Long productId,List<SupplyFormulaToPersist> suppliesFormulas) {
        var list = springJpaSupplyFormulaRepository.findAllByProduct_ProductId(productId);
        if (!list.isEmpty()) springJpaSupplyFormulaRepository.deleteAllByProduct_ProductId(productId);
        var entities = supplyFormulaMapper.toSuppliesFormulasJpa(suppliesFormulas);
        var result = springJpaSupplyFormulaRepository.saveAll(entities);
        return supplyFormulaMapper.toSuppliesFormulas(result);
    }

    @Override
    public List<SupplyFormula> getSuppliesFormulas(Long productId) {
        var result = springJpaSupplyFormulaRepository.findAllByProduct_ProductId(productId);
        return supplyFormulaMapper.toSuppliesFormulas(result);
    }

    @Override
    public List<Product> validateSupplyDeletion(Long supplyId) {
        var result = springJpaSupplyFormulaRepository.findAllBySupply_SupplyIdAndProductState(supplyId, true);
        if (result.size() == 0) return null;
        var products = new ArrayList<ProductJpaEntity>();
        for(SupplyFormulaJpaEntity aux: result){
            products.add(aux.getProduct());
        }
        return productMapper.toProducts(products);
    }
}
