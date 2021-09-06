package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        var merchandiseEntryToRegister = MerchandiseEntryToRegister.builder().entryDate(merchandiseEntryDTO.getEntryDate().atStartOfDay()).entryType(merchandiseEntryDTO.getEntryType())
                .producerId(merchandiseEntryDTO.getProducerId()).build();
        var merchandiseEntry = merchandiseEntryUseCase.registerMerchandiseEntry(merchandiseEntryToRegister, communityId);
        var details = merchandiseEntryDetailsUseCase.registerMerchandiseEntryDetails(merchandiseEntryDTO.getDetailsToRegister(), merchandiseEntry);

        return MerchandiseEntryDTO.builder()
                .merchandiseEntry(merchandiseEntry)
                .details(details)
                .build();
    }
}
