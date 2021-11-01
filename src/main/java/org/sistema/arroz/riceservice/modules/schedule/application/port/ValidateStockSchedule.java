package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryDetailToRegister;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ScheduleToRegister;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ValidateStockUseCase;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleStockException;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesFormulasUseCase;

import java.util.ArrayList;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ValidateStockSchedule implements ValidateStockUseCase {
    private final GetSuppliesFormulasUseCase getSuppliesFormulasUseCase;

    @Override
    public List<MerchandiseEntryDetailToRegister> validateStockSchedule(Long communityId, ScheduleToRegister scheduleToRegister) {
        var suppliesFormula = getSuppliesFormulasUseCase.getSuppliesFormulas(scheduleToRegister.getProductId());
        var merchandiseEntryDetails = new ArrayList<MerchandiseEntryDetailToRegister>(suppliesFormula.size());
        for(var supplyFormula: suppliesFormula){
            var supply = supplyFormula.getSupply();
            var entryCant = supplyFormula.getCantForHectare()*scheduleToRegister.getHectares();
            var actualCant = supply.getStock();
            if (actualCant - entryCant < supply.getStockMin())
                throw new ScheduleStockException(scheduleToRegister.getProductId(), scheduleToRegister.getHectares());
            merchandiseEntryDetails.add(MerchandiseEntryDetailToRegister.builder()
                    .supplyId(supply.getSupplyId()).entryCant(entryCant).build());
        }
        return merchandiseEntryDetails;
    }
}
