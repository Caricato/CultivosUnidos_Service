package org.sistema.arroz.riceservice.modules.schedule.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.GetScheduleDTO;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.GetScheduleDTOMapper;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.GetSchedulesUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/schedules")
public class GetSchedulesController {
    private final GetSchedulesUseCase getSchedulesUseCase;
    private final GetScheduleDTOMapper getScheduleDTOMapper;

    @GetMapping("/{communityId}")
    public List<GetScheduleDTO> getSchedules(@PathVariable Long communityId){
        var schedules = getSchedulesUseCase.getSchedules(communityId);
        return getScheduleDTOMapper.getSchedulesDTO(schedules);
    }
}
