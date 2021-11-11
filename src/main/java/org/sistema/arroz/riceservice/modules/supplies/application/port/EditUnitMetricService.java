package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.EditUnitMetricUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.UnitMetricToEdit;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.EditUnitMetricPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.UnitMetric;

@UseCase
@RequiredArgsConstructor
public class EditUnitMetricService implements EditUnitMetricUseCase {
    private final EditUnitMetricPort editUnitMetricPort;

    @Override
    public UnitMetric editUnitMetric(Long unitMetricId, UnitMetricToEdit unitMetricToEdit) {
        return editUnitMetricPort.editUnitMetric(unitMetricId, unitMetricToEdit);
    }
}
