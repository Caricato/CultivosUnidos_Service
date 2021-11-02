package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.LocalDateTimePeruZone;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryDetailToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.MerchandiseEntryToRegister;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.RegisterProductInUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowSubtype;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowType;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.FinishScheduleUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.FinishSchedulePort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.FreeAllHectaresPort;

import java.util.ArrayList;

@UseCase
@RequiredArgsConstructor
public class FinishScheduleService implements FinishScheduleUseCase {
    private final FinishSchedulePort finishSchedulePort;
    private final FreeAllHectaresPort freeAllHectaresPort;
    private final RegisterProductInUseCase registerProductInUseCase;

    @Override
    public void finishSchedule(Long scheduleId) {
        var schedule = finishSchedulePort.finishSchedule(scheduleId);
        freeAllHectaresPort.freeAllHectares(scheduleId);
        var merchandiseEntry = MerchandiseEntryToRegister.builder()
                .entryDate(LocalDateTimePeruZone.now())
                .entryType(MerchandiseFlowType.CRONOGRAMA)
                .subtype(MerchandiseFlowSubtype.ENTRADA_PRODUCTO).build();
        var detailToRegister = new ArrayList<MerchandiseEntryDetailToRegister>(1);
        detailToRegister.add(MerchandiseEntryDetailToRegister.builder()
                .productId(schedule.getProduct().getProductId()).entryCant(schedule.getHectares()*schedule.getProduct().getRelationSacks()).build());
        registerProductInUseCase.registerProductIn(merchandiseEntry, detailToRegister, schedule.getProduct().getCommunity().getCommunityId());
    }
}
