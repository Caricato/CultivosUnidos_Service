package org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.AgricultureCommunityToRegister;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.RegisterAgricultureCommunityUseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/agriculture_community")
public class RegisterAgricultureCommunityController {
    private final RegisterAgricultureCommunityUseCase registerAgricultureCommunityUseCase;

    @PostMapping(value = "")
    public AgricultureCommunity registerAgricultureCommunity(
            @RequestBody AgricultureCommunityToRegister agricultureCommunityToRegister){
        return registerAgricultureCommunityUseCase.registerAgricultureCommunity(agricultureCommunityToRegister);
    }
}
