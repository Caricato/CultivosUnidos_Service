package org.sistema.arroz.riceservice.modules.schedule.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.FreeHectaresUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/schedules")
public class FreeHectaresController {
    private final FreeHectaresUseCase freeHectaresUseCase;

    @PutMapping("/detail/free/{scheduleDetailId}")
    public void freeHectares(@PathVariable Long scheduleDetailId){
        freeHectaresUseCase.freeHectares(scheduleDetailId);
    }
}
