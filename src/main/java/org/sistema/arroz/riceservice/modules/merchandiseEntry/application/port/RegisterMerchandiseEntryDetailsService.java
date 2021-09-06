package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryDetailToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.RegisterMerchandiseEntryDetailsUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.MerchandiseEntryDetailToPersist;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.RegisterMerchandiseEntryDetailsPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntry;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryDetail;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyNotFoundException;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterMerchandiseEntryDetailsService implements RegisterMerchandiseEntryDetailsUseCase {
    private final RegisterMerchandiseEntryDetailsPort registerMerchandiseEntryDetailsPort;
    private final GetSupplyPort getSupplyPort;

    @Override
    public List<MerchandiseEntryDetail> registerMerchandiseEntryDetails(List<MerchandiseEntryDetailToRegister> details, MerchandiseEntry merchandiseEntry) {
        var detailsToPersist = new ArrayList<MerchandiseEntryDetailToPersist>(details.size());
        for (MerchandiseEntryDetailToRegister detail: details){
            var detailToPersist = new MerchandiseEntryDetailToPersist();
            detailToPersist.setEntryCant(detail.getEntryCant());
            detailToPersist.setMerchandiseEntry(merchandiseEntry);
            var supply = getSupplyPort.getSupplyById(detail.getSupplyId());
            if (supply.isEmpty()) throw new SupplyNotFoundException(detail.getSupplyId());
            detailToPersist.setSupply(supply.get());
            detailsToPersist.add(detailToPersist);
        }
        return registerMerchandiseEntryDetailsPort.registerMerchandiseEntryDetails(detailsToPersist);
    }
}
