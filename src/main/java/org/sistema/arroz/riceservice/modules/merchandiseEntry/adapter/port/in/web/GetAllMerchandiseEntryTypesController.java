package org.sistema.arroz.riceservice.modules.merchandiseEntry.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in.GetAllMerchandiseEntryTypesUseCase;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/merchandise_entry")
public class GetAllMerchandiseEntryTypesController {
    private final GetAllMerchandiseEntryTypesUseCase getAllMerchandiseEntryTypesUseCase;

    @GetMapping(value = "/types")
    public List<MerchandiseFlowType> getAllMerchandiseEntryTypes(){
        return getAllMerchandiseEntryTypesUseCase.getAllMerchandiseEntryTypes();
    }
}
