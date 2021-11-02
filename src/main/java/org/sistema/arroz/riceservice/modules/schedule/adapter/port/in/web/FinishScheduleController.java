package org.sistema.arroz.riceservice.modules.schedule.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.FinishScheduleUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/schedules")
public class FinishScheduleController {
    private final FinishScheduleUseCase finishScheduleUseCase;

    @PutMapping("/{scheduleId}")
    public void finishSchedule(@PathVariable Long scheduleId){
        finishScheduleUseCase.finishSchedule(scheduleId);
    }
}
