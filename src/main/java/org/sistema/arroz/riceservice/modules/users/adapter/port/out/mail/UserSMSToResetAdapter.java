package org.sistema.arroz.riceservice.modules.users.adapter.port.out.mail;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.PersistenceAdapter;
import org.sistema.arroz.riceservice.hexagonal.helpers.SMSHelper;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.sistema.arroz.riceservice.modules.users.application.port.out.SendSMSToResetPort;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserSMSToResetAdapter implements SendSMSToResetPort {
    private final SMSHelper smsHelper;

    @Override
    public void sendSMSToResetPassword(Producer producer) {
        var message = "\nEstimado "+producer.getProducerName()+" "+producer.getProducerFirstLastName()+":\n"
                +"Se envió a su correo el enlace para restablecer su contraseña.";
        smsHelper.smsSubmit(producer.getPhone(), message);
    }
}
