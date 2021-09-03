package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.hexagonal.queries.Paginator;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetSuppliesUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetSuppliesPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

@UseCase
@RequiredArgsConstructor
public class GetSuppliesService implements GetSuppliesUseCase {

    private final GetSuppliesPort getSuppliesPort;

    @Override
    public Paginator<Supply> getSupplies(Filters filters, Long communityId) {
        return getSuppliesPort.getSupplies(filters, communityId);
    }
}
