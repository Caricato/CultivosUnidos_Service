package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetSupplyUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyNotFoundException;

@UseCase
@RequiredArgsConstructor
public class GetSupplyService implements GetSupplyUseCase {
    private final GetSupplyPort getSupplyPort;

    @Override
    public Supply getSupply(Long supplyId) {
        var supply = getSupplyPort.getSupplyById(supplyId);
        if (supply.isEmpty()) throw new SupplyNotFoundException(supplyId);
        return supply.get();
    }
}
