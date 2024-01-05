package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.MerchandiseEntryFacade;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.*;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/merchandise_entry")
public class RegisterMerchandiseEntryController {
    private final MerchandiseEntryFacade merchandiseEntryFacade;

    @PostMapping(value = "/{communityId}")
    public MerchandiseEntryDTO registerMerchandiseEntry(@RequestBody MerchandiseEntryToRegisterDTO merchandiseEntryDTO,
                                                        @PathVariable Long communityId){

        var merchandiseEntry = MerchandiseEntryToRegister.builder().entryDate(merchandiseEntryDTO.getEntryDate().atStartOfDay()).entryType(merchandiseEntryDTO.getEntryType())
                .producerId(merchandiseEntryDTO.getProducerId()).subtype(merchandiseEntryDTO.getSubtype()).build();
        return merchandiseEntryFacade.registerMerchandiseEntry(merchandiseEntryDTO, communityId, merchandiseEntry);
    }
}
