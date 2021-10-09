package org.sistema.arroz.riceservice.modules.users.application.port.in;

public interface ValidateLoginUseCase {
    GetValidatedUserDTO validateLogin(LoginToValidate loginToValidate);
}
