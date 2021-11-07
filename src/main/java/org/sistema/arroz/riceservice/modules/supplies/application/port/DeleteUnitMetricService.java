package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.DeleteUnitMetricUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.DeleteUnitMetricPort;

@UseCase
@RequiredArgsConstructor
public class DeleteUnitMetricService implements DeleteUnitMetricUseCase {
    private final DeleteUnitMetricPort deleteUnitMetricPort;

    @Override
    public void deleteUnitMetric(Long unitMetricId) {
        deleteUnitMetricPort.deleteUnitMetric(unitMetricId);
    }
}
