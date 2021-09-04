package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetAllSuppliesUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetAllSuppliesPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class GetAllSuppliesService implements GetAllSuppliesUseCase {
    private final GetAllSuppliesPort getAllSuppliesPort;

    @Override
    public List<Supply> getAllSupplies(String search, Long communityId) {
        return getAllSuppliesPort.getAllSupplies(search, communityId);
    }
}
