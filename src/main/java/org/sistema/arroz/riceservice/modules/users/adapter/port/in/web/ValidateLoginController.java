package org.sistema.arroz.riceservice.modules.users.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GetValidatedUserDTO;
import org.sistema.arroz.riceservice.modules.users.application.port.in.LoginToValidate;
import org.sistema.arroz.riceservice.modules.users.application.port.in.ValidateLoginUseCase;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class ValidateLoginController {
    private final ValidateLoginUseCase validateLoginUseCase;

    @PostMapping(value = "/login")
    public GetValidatedUserDTO validateLogin(@RequestBody LoginToValidate loginToValidate){
        return validateLoginUseCase.validateLogin(loginToValidate);
    }
}
