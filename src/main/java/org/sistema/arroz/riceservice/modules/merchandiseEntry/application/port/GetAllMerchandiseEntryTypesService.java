package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.GetAllMerchandiseEntryTypesUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryType;

import java.util.ArrayList;
import java.util.List;

@UseCase
public class GetAllMerchandiseEntryTypesService implements GetAllMerchandiseEntryTypesUseCase {
    @Override
    public List<MerchandiseEntryType> getAllMerchandiseEntryTypes() {
        var merchandiseEntryTypes = new ArrayList<MerchandiseEntryType>();
        merchandiseEntryTypes.add(MerchandiseEntryType.COMPRA);
        merchandiseEntryTypes.add(MerchandiseEntryType.ASOCIACION);
        return merchandiseEntryTypes;
    }
}
