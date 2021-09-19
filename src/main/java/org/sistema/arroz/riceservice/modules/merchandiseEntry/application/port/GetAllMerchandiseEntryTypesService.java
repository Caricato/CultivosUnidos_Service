package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.GetAllMerchandiseEntryTypesUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowType;

import java.util.ArrayList;
import java.util.List;

@UseCase
public class GetAllMerchandiseEntryTypesService implements GetAllMerchandiseEntryTypesUseCase {
    @Override
    public List<MerchandiseFlowType> getAllMerchandiseEntryTypes() {
        var merchandiseEntryTypes = new ArrayList<MerchandiseFlowType>();
        merchandiseEntryTypes.add(MerchandiseFlowType.COMPRA);
        merchandiseEntryTypes.add(MerchandiseFlowType.ASOCIACION);
        return merchandiseEntryTypes;
    }
}
