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
    private final RegisterMerchandiseEntryUseCase merchandiseEntryUseCase;
    private final RegisterMerchandiseEntryDetailsUseCase merchandiseEntryDetailsUseCase;

    @PostMapping(value = "/{communityId}")
    public MerchandiseEntryDTO registerMerchandiseEntry(@RequestBody MerchandiseEntryToRegisterDTO merchandiseEntryDTO,
                                                        @PathVariable Long communityId){

        switch(merchandiseEntryDTO.getSubtype()){
            case ENTRADA_INSUMO:
                var merchandiseEntryToRegister = MerchandiseEntryToRegister.builder().entryDate(merchandiseEntryDTO.getEntryDate().atStartOfDay()).entryType(merchandiseEntryDTO.getEntryType())
                        .producerId(merchandiseEntryDTO.getProducerId()).subtype(merchandiseEntryDTO.getSubtype()).build();
                var merchandiseEntry = merchandiseEntryUseCase.registerMerchandiseEntry(merchandiseEntryToRegister, communityId);
                var details = merchandiseEntryDetailsUseCase.registerMerchandiseEntryDetails(merchandiseEntryDTO.getDetailsToRegister(), merchandiseEntry);

                return MerchandiseEntryDTO.builder()
                        .merchandiseFlow(merchandiseEntry)
                        .details(details)
                        .build();
            case SALIDA_INSUMO:
                //TODO
            case ENTRADA_PRODUCTO:
                //TODO
            default:
                throw new MerchandiseFlowInvalidException(merchandiseEntryDTO.getSubtype().toString());
        }
    }
}
