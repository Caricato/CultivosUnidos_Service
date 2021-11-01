package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.LocalDateTimePeruZone;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryDetailToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.RegisterSupplyInUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowSubtype;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowType;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.DeleteScheduleUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.DeleteScheduleDetailsPort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.DeleteSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.GetSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDeleteException;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleType;
import org.sistema.arroz.riceservice.modules.supplyFormula.application.port.in.GetSuppliesFormulasUseCase;

import java.util.ArrayList;

@UseCase
@RequiredArgsConstructor
public class DeleteScheduleService implements DeleteScheduleUseCase {
    private final GetSchedulePort getSchedulePort;
    private final DeleteSchedulePort deleteSchedulePort;
    private final DeleteScheduleDetailsPort deleteScheduleDetailsPort;
    private final GetSuppliesFormulasUseCase getSuppliesFormulasUseCase;
    private final RegisterSupplyInUseCase registerSupplyInUseCase;

    @Override
    public void deleteSchedule(Long scheduleId) {
        var schedule = getSchedulePort.getSchedule(scheduleId);
        if (schedule == null || !schedule.getState().equals(ScheduleType.PENDING))
            throw new ScheduleDeleteException(scheduleId);
        deleteScheduleDetailsPort.deleteScheduleDetails(scheduleId);
        deleteSchedulePort.deleteSchedule(scheduleId);
        updateSupplyStock(schedule);
    }

    public void updateSupplyStock(Schedule schedule){
        var supplyFormulas = getSuppliesFormulasUseCase.getSuppliesFormulas(schedule.getProduct().getProductId());
        var merchandiseEntryDetails = new ArrayList<MerchandiseEntryDetailToRegister>(supplyFormulas.size());
        for (var supplyFormula: supplyFormulas){
            var entryCant = supplyFormula.getCantForHectare()*schedule.getHectares();
            merchandiseEntryDetails.add(MerchandiseEntryDetailToRegister.builder()
                    .supplyId(supplyFormula.getSupply().getSupplyId()).entryCant(entryCant).build());

        }
        registerSupplyInUseCase.registerSupplyIn(
                MerchandiseEntryToRegister.builder().entryType(MerchandiseFlowType.CRONOGRAMA)
                        .subtype(MerchandiseFlowSubtype.ENTRADA_INSUMO)
                        .entryDate(LocalDateTimePeruZone.now())
                        .build(),
                merchandiseEntryDetails, schedule.getProduct().getCommunity().getCommunityId());
    }
}
