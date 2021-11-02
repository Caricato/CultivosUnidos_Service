package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.*;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowInvalidException;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/merchandise_entry")
public class RegisterMerchandiseEntryController {
    private final RegisterProductInUseCase registerProductInUseCase;
    private final RegisterSupplyInUseCase registerSupplyInUseCase;
    private final RegisterSupplyOutUseCase registerSupplyOutUseCase;

    @PostMapping(value = "/{communityId}")
    public MerchandiseEntryDTO registerMerchandiseEntry(@RequestBody MerchandiseEntryToRegisterDTO merchandiseEntryDTO,
                                                        @PathVariable Long communityId){

        var merchandiseEntry = MerchandiseEntryToRegister.builder().entryDate(merchandiseEntryDTO.getEntryDate().atStartOfDay()).entryType(merchandiseEntryDTO.getEntryType())
                .producerId(merchandiseEntryDTO.getProducerId()).subtype(merchandiseEntryDTO.getSubtype()).build();
        switch(merchandiseEntryDTO.getSubtype()) {
            case ENTRADA_INSUMO:
                return registerSupplyInUseCase.registerSupplyIn(merchandiseEntry, merchandiseEntryDTO.getDetailsToRegister(), communityId);
            case SALIDA_INSUMO:
                return registerSupplyOutUseCase.registerSupplyOut(merchandiseEntry, merchandiseEntryDTO.getDetailsToRegister(), communityId);
            case ENTRADA_PRODUCTO:
                return registerProductInUseCase.registerProductIn(merchandiseEntry, merchandiseEntryDTO.getDetailsToRegister(), communityId);
            default:
                throw new MerchandiseFlowInvalidException(merchandiseEntryDTO.getSubtype().toString());
        }
    }
}
