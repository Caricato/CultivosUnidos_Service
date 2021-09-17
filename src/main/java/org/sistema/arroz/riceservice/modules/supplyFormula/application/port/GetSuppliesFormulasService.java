package org.sistema.arroz.riceservice.modules.supplyFormula.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesFormulasUseCase;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.out.GetSuppliesFormulasPort;
import org.sistema.arroz.riceservice.modules.supplyFormula.domain.SupplyFormula;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetSuppliesFormulasService implements GetSuppliesFormulasUseCase {
    private final GetSuppliesFormulasPort getSuppliesFormulasPort;

    @Override
    public List<SupplyFormula> getSuppliesFormulas(Long productId) {
        return getSuppliesFormulasPort.getSuppliesFormulas(productId);
    }
}
