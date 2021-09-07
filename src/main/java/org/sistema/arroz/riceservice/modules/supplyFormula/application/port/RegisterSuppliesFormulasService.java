package org.sistema.arroz.riceservice.modules.supplyFormula.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.products.domain.Product;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyNotFoundException;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.RegisterSuppliesFormulasUseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.SupplyFormulaToRegister;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.RegisterSuppliesFormulasPort;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.SupplyFormulaToPersist;
import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterSuppliesFormulasService implements RegisterSuppliesFormulasUseCase {
    private final RegisterSuppliesFormulasPort registerSuppliesFormulasPort;
    private final GetSupplyPort getSupplyPort;

    @Override
    public List<SupplyFormula> registerSuppliesFormulas(List<SupplyFormulaToRegister> suppliesFormulaToRegister, Product product) {
        var suppliesToPersist = new ArrayList<SupplyFormulaToPersist>(suppliesFormulaToRegister.size());
        for(SupplyFormulaToRegister supplyFormulaToRegister: suppliesFormulaToRegister){
            var supply = getSupplyPort.getSupplyById(supplyFormulaToRegister.getSupplyId());
            if (supply.isEmpty()) throw new SupplyNotFoundException(supplyFormulaToRegister.getSupplyId());
            var supplyToPersist = SupplyFormulaToPersist.builder()
                    .product(product).cantForHectare(supplyFormulaToRegister.getCantForHectare())
                    .supply(supply.get()).build();

            suppliesToPersist.add(supplyToPersist);
        }
        return registerSuppliesFormulasPort.registerSuppliesFormulas(suppliesToPersist);
    }
}
