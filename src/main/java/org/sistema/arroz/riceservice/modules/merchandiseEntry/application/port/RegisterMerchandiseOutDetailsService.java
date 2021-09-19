package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryDetailToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.RegisterMerchandiseOutDetailsUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.ValidateMerchandiseOutUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.MerchandiseEntryDetailToPersist;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.out.RegisterMerchandiseEntryDetailsPort;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlow;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowDetail;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.GetSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.UpdateSupplyStockPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyNotFoundException;
import org.sistema.arroz.riceservice.modules.supplies.domain.SupplyStockMinBrokenException;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class RegisterMerchandiseOutDetailsService implements RegisterMerchandiseOutDetailsUseCase, ValidateMerchandiseOutUseCase {
    private final GetSupplyPort getSupplyPort;
    private final UpdateSupplyStockPort updateSupplyStockPort;
    private final RegisterMerchandiseEntryDetailsPort registerMerchandiseEntryDetailsPort;

    @Override
    public List<MerchandiseFlowDetail> registerMerchandiseOutDetails(List<MerchandiseEntryDetailToRegister> details, MerchandiseFlow merchandiseFlow) {
        var detailsToPersist = new ArrayList<MerchandiseEntryDetailToPersist>(details.size());
        for (MerchandiseEntryDetailToRegister detail: details){
            var detailToPersist = new MerchandiseEntryDetailToPersist();
            detailToPersist.setEntryCant(detail.getEntryCant());
            detailToPersist.setMerchandiseFlow(merchandiseFlow);
            var supply = getSupplyPort.getSupplyById(detail.getSupplyId());
            if (supply.isEmpty()) throw new SupplyNotFoundException(detail.getSupplyId());
            supply.get().setStock(updateStock(supply.get(),detailToPersist.getEntryCant()));
            detailToPersist.setSupply(supply.get());
            detailsToPersist.add(detailToPersist);

            updateSupplyStockPort.updateSupplyStock(supply.get().getStock(), detail.getSupplyId());
        }
        return registerMerchandiseEntryDetailsPort.registerMerchandiseEntryDetails(detailsToPersist);
    }

    private Double updateStock(Supply supply, Double offset){
        var stockMin = supply.getStockMin();
        var actualStock = supply.getStock();
        if (actualStock-offset < stockMin) throw new SupplyStockMinBrokenException(supply.getSupplyId(), supply.getSupplyName(), actualStock, stockMin, offset);
        return (actualStock-offset);
    }

    @Override
    public boolean validateMerchandiseOut(List<MerchandiseEntryDetailToRegister> details) {
        for (MerchandiseEntryDetailToRegister detail: details){
            var supplyOptional = getSupplyPort.getSupplyById(detail.getSupplyId());
            if (supplyOptional.isEmpty()) throw new SupplyNotFoundException(detail.getSupplyId());
            var supply = supplyOptional.get();
            var stockMin = supply.getStockMin();
            var actualStock = supply.getStock();
            if (actualStock-detail.getEntryCant() < stockMin) throw new SupplyStockMinBrokenException(supply.getSupplyId(), supply.getSupplyName(), actualStock, stockMin, detail.getEntryCant());
        }
        return true;
    }
}
