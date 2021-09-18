package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryDetailToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.RegisterMerchandiseEntryDetailsUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.MerchandiseEntryDetailToPersist;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.RegisterMerchandiseEntryDetailsPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.UpdateSupplyStockPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyNotFoundException;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterMerchandiseEntryDetailsService implements RegisterMerchandiseEntryDetailsUseCase {
    private final RegisterMerchandiseEntryDetailsPort registerMerchandiseEntryDetailsPort;
    private final GetSupplyPort getSupplyPort;
    private final UpdateSupplyStockPort updateSupplyStockPort;

    @Override
    public List<MerchandiseFlowDetail> registerMerchandiseEntryDetails(List<MerchandiseEntryDetailToRegister> details, MerchandiseFlow merchandiseFlow) {
        var detailsToPersist = new ArrayList<MerchandiseEntryDetailToPersist>(details.size());
        for (MerchandiseEntryDetailToRegister detail: details){
            var detailToPersist = new MerchandiseEntryDetailToPersist();
            detailToPersist.setEntryCant(detail.getEntryCant());
            detailToPersist.setMerchandiseFlow(merchandiseFlow);
            var supply = getSupplyPort.getSupplyById(detail.getSupplyId());
            if (supply.isEmpty()) throw new SupplyNotFoundException(detail.getSupplyId());
            supply.get().setStock(supply.get().getStock()+detailToPersist.getEntryCant());
            detailToPersist.setSupply(supply.get());
            detailsToPersist.add(detailToPersist);
            
            updateSupplyStockPort.updateSupplyStock(detail.getEntryCant(), detail.getSupplyId());
        }
        return registerMerchandiseEntryDetailsPort.registerMerchandiseEntryDetails(detailsToPersist);
    }
}
