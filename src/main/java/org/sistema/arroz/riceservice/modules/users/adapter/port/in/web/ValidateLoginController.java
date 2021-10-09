package org.sistema.arroz.riceservice.modules.users.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.users.application.port.in.GetValidatedUserDTO;
import org.sistema.arroz.riceservice.modules.users.application.port.in.LoginToValidate;
import org.sistema.arroz.riceservice.modules.users.application.port.in.ValidateLoginUseCase;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class ValidateLoginController {
    private final ValidateLoginUseCase validateLoginUseCase;

    @GetMapping(value = "/login")
    public GetValidatedUserDTO validateLogin(LoginToValidate loginToValidate){
        return validateLoginUseCase.validateLogin(loginToValidate);
    }
}
