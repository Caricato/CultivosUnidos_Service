package org.sistema.arroz.riceservice.modules.notifications.application.port.in;

public interface SendSMSToResetUseCase {
    void sendSMSToReset(String dni, String message);
}
