package org.sistema.arroz.riceservice.modules.supplies.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.EditSupplyUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.SupplyToEdit;
import org.sistema.arroz.riceservice.modules.supplies.application.port.out.EditSupplyPort;
import org.sistema.arroz.riceservice.modules.supplies.domain.Supply;

@UseCase
@RequiredArgsConstructor
public class EditSupplyService implements EditSupplyUseCase {

    private final EditSupplyPort editSupplyPort;

    @Override
    public Supply editSupply(SupplyToEdit supplyToEdit) {
        return editSupplyPort.editSupply(supplyToEdit);
    }
}
