package org.sistema.arroz.riceservice.modules.users.adapter.port.in.web;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.WebAdapter;
import org.sistema.arroz.riceservice.modules.users.application.port.in.SendMailToResetUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.SendSMSToResetUseCase;
import org.sistema.arroz.riceservice.modules.users.application.port.in.UserToResetPassword;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

@WebAdapter
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class SendMailToResetController {
    private final SendMailToResetUseCase sendMailToResetUseCase;

    @PostMapping(value = "/reset/mail")
    public void sendMailToResetPassword(@RequestBody UserToResetPassword user, HttpServletRequest request) throws MessagingException {
        sendMailToResetUseCase.sendMailToReset(user.getDni(), request.getHeader("referer")+"restaurar");
    }
}
