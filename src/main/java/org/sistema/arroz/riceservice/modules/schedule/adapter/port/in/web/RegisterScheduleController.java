package org.sistema.arroz.riceservice.modules.schedule.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.RegisterScheduleUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ScheduleToRegisterDTO;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ScheduleToRegisterDTOMapper;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/schedules")
public class RegisterScheduleController {
    private final RegisterScheduleUseCase registerScheduleUseCase;
    private final ScheduleToRegisterDTOMapper scheduleToRegisterMapper;

    @PostMapping("/{communityId}")
    public Schedule registerSchedule(@RequestBody ScheduleToRegisterDTO scheduleToRegister,
                                     @PathVariable Long communityId){
        return registerScheduleUseCase.registerSchedule(communityId, scheduleToRegisterMapper.toScheduleToRegister(scheduleToRegister));
    }
}
