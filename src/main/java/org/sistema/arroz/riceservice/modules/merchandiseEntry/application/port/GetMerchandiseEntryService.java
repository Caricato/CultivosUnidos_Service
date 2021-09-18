package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.GetMerchandiseEntryUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.GetMerchandiseEntryPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowNotFoundException;

@UseCase
@RequiredArgsConstructor
public class GetMerchandiseEntryService implements GetMerchandiseEntryUseCase {

    private final GetMerchandiseEntryPort getMerchandiseEntryPort;

    @Override
    public MerchandiseFlow getMerchandiseEntryById(Long merchandiseEntryId) {
        var result = getMerchandiseEntryPort.getMerchandiseEntryById(merchandiseEntryId);
        if (result.isEmpty()) throw new MerchandiseFlowNotFoundException(merchandiseEntryId);
        return result.get();
    }
}
