package org.sistema.arroz.riceservice.modules.users.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GeneratePasswordUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.PasswordToGenerate;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class GeneratePasswordController {
    private final GeneratePasswordUseCase generatePasswordUseCase;

    @PostMapping(value = "/reset")
    public void validateLogin(@RequestBody PasswordToGenerate passwordToGenerate){
        generatePasswordUseCase.generatePassword(passwordToGenerate.getToken(), passwordToGenerate.getPassword());
    }
}
