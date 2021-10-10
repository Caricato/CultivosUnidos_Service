package org.sistema.arroz.riceservice.modules.users.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GeneratePasswordUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class GeneratePasswordController {
    private final GeneratePasswordUseCase generatePasswordUseCase;

    @PostMapping(value = "/first_login/{userId}")
    public void validateLogin(@RequestParam String password, @PathVariable Long userId){
        generatePasswordUseCase.generatePassword(userId, password);
    }
}
