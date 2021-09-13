package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetAllSuppliesForEntriesDTO;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetAllSuppliesForEntriesMapper;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetAllSuppliesUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies")
public class GetAllSuppliesForEntriesController {
    private final GetAllSuppliesUseCase getAllSuppliesUseCase;
    private final GetAllSuppliesForEntriesMapper getAllSuppliesForEntriesMapper;

    @GetMapping(value = "/aux/{communityId}")
    public List<GetAllSuppliesForEntriesDTO> getAllSuppliesForEntries(@PathVariable Long communityId){
        var supplies =  getAllSuppliesUseCase.getAllSupplies("", communityId);
        return getAllSuppliesForEntriesMapper.toGetAllSuppliesForEntries(supplies);
    }
}
