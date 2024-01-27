package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.queries.Filters;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.*;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowSubtype;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MerchandiseEntryFacade {
    private final RegisterProductInUseCase registerProductInUseCase;
    private final RegisterSupplyInUseCase registerSupplyInUseCase;
    private final RegisterSupplyOutUseCase registerSupplyOutUseCase;
    private final GetMerchandiseEntryUseCase getMerchandiseEntryUseCase;
    private final GetMerchandiseEntryDetailUseCase getMerchandiseEntryDetailUseCase;
    private final GetMerchandiseProductDetailUseCase getMerchandiseProductDetailUseCase;

    public MerchandiseEntryDTO registerMerchandiseEntry(MerchandiseEntryToRegisterDTO merchandiseEntryDTO, Long communityId, MerchandiseEntryToRegister merchandiseEntry){
        switch (merchandiseEntryDTO.getSubtype()) {
            case ENTRADA_INSUMO:
                    return registerSupplyInUseCase.registerSupplyIn(merchandiseEntry, merchandiseEntryDTO.getDetailsToRegister(), communityId);
            case SALIDA_INSUMO:
                    return registerSupplyOutUseCase.registerSupplyOut(merchandiseEntry, merchandiseEntryDTO.getDetailsToRegister(), communityId);
            case ENTRADA_PRODUCTO:
                    return registerProductInUseCase.registerProductIn(merchandiseEntry, merchandiseEntryDTO.getDetailsToRegister(), communityId);
            default:
                return null;
        }
    }

    public MerchandiseEntryPageDTO getMerchandiseEntryDetail(Filters filters, Long merchandiseEntryId){
        var merchandise = getMerchandiseEntryUseCase.getMerchandiseEntryById(merchandiseEntryId);
        if (!merchandise.getSubtype().equals(MerchandiseFlowSubtype.ENTRADA_PRODUCTO)){
            var details = getMerchandiseEntryDetailUseCase.getMerchandiseEntryDetails(filters, merchandiseEntryId);

            return MerchandiseSupplyPageDTO.builder()
                    .merchandiseFlow(merchandise)
                    .detailPage(details).build();
        }
        else{
            var detailsProduct = getMerchandiseProductDetailUseCase.getMerchandiseProductDetails(filters, merchandiseEntryId);
            return MerchandiseProductPageDTO.builder()
                    .merchandiseFlow(merchandise)
                    .detailPage(detailsProduct).build();
        }
    }
}
