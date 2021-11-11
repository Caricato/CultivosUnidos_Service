package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.out.GetAgricultureCommunityPort;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunityNotFoundException;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.RegisterSupplyUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToRegister;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.RegisterSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyStockInconsistencyException;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

@UseCase
@RequiredArgsConstructor
public class RegisterSupplyService implements RegisterSupplyUseCase {
    private final RegisterSupplyPort registerSupplyPort;
    private final GetAgricultureCommunityPort getAgricultureCommunityPort;

    @Override
    public Supply registerSupply(SupplyToRegister supplyToRegister) {
        System.out.println(supplyToRegister);
        if (supplyToRegister.getStockMin() > supplyToRegister.getStock())
            throw new SupplyStockInconsistencyException(supplyToRegister.getStock(), supplyToRegister.getStockMin());
        var community = getAgricultureCommunityPort.findCommunityById(supplyToRegister.getCommunityId());
        if (community == null)
            throw new AgricultureCommunityNotFoundException(supplyToRegister.getCommunityId());
        return registerSupplyPort.registerSupply(supplyToRegister, community);
    }
}
