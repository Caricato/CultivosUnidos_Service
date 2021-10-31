package org.sistema.arroz.riceservice.modules.schedule.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.*;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/schedules")
public class GetScheduleDetailController {
    private final GetScheduleUseCase getScheduleUseCase;
    private final GetScheduleDetailsUseCase getScheduleDetailsUseCase;
    private final GetScheduleDTOMapper getScheduleDTOMapper;
    private final GetScheduleDetailDTOMapper getScheduleDetailDTOMapper;

    @GetMapping("/detail/{scheduleId}")
    public GetScheduleAndDetailsDTO getScheduleDetail(@PathVariable Long scheduleId){
        var schedule = getScheduleUseCase.getSchedule(scheduleId);
        var scheduleDetails = getScheduleDetailsUseCase.getScheduleDetails(scheduleId);
        return GetScheduleAndDetailsDTO.builder()
                .getScheduleDTO(getScheduleDTOMapper.getScheduleDTO(schedule))
                .getScheduleDetailDTO(getScheduleDetailDTOMapper.toScheduleDetailsDTO(scheduleDetails))
                .build();
    }
}
