package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetSuppliesUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetSuppliesPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetSuppliesService implements GetSuppliesUseCase {

    private final GetSuppliesPort getSuppliesPort;

    @Override
    public List<Supply> getSupplies(Long communityId) {
        return getSuppliesPort.getSupplies(communityId);
    }
}
