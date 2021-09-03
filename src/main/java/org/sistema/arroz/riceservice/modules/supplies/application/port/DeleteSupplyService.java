package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.DeleteSupplyUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.DeleteSupplyPort;

@UseCase
@RequiredArgsConstructor
public class DeleteSupplyService implements DeleteSupplyUseCase {

    private final DeleteSupplyPort deleteSupplyPort;

    @Override
    public Long deleteSupply(Long supplyId) {
        return deleteSupplyPort.deleteSupply(supplyId);
    }
}
