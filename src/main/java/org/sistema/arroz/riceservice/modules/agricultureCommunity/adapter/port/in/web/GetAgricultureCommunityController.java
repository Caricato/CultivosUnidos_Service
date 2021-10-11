package org.sistema.arroz.riceservice.modules.agricultureCommunity.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.application.port.in.GetAgricultureCommunityUseCase;
import org.sistema.arroz.riceservice.modules.agricultureCommunity.domain.AgricultureCommunity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/agriculture_community")
public class GetAgricultureCommunityController {
    private final GetAgricultureCommunityUseCase getAgricultureCommunityUseCase;

    @GetMapping("/{communityId}")
    public AgricultureCommunity getAgricultureCommunity(@PathVariable Long communityId){
        var community =  getAgricultureCommunityUseCase.findCommunityById(communityId);
        community.getSupervisor().getUser().setPassword(null);
        return community;
    }
}
