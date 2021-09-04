package org.sistema.arroz.riceservice.modules.supplies.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Context;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.ExportSuppliesUseCase;
import org.sistema.arroz.riceservice.modules.supplies.application.port.in.GetAllSuppliesUseCase;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/supplies")
public class ExportSuppliesController {
    private final ExportSuppliesUseCase exportSuppliesUseCase;
    private final GetAllSuppliesUseCase getAllSuppliesUseCase;

    @GetMapping(value ="/reports/{communityId}")
    public void exportSupplies(@Context HttpServletResponse response,
            @RequestParam(value = "search", defaultValue = "") String search, @PathVariable Long communityId) throws IOException {
        var supplies = getAllSuppliesUseCase.getAllSupplies(search, communityId);
        exportSuppliesUseCase.exportSupplies(supplies, response.getOutputStream());
    }
}
