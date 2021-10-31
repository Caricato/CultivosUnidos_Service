package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.FreeHectaresUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.FreeHectaresPort;

@UseCase
@RequiredArgsConstructor
public class FreeHectaresService implements FreeHectaresUseCase {
    private final FreeHectaresPort freeHectaresPort;

    @Override
    public void freeHectares(Long scheduleDetailId) {
        freeHectaresPort.freeHectares(scheduleDetailId);
    }
}
