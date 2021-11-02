package org.sistema.arroz.riceservice.modules.notifications.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.hexagonal.sms.Messages;
import org.sistema.arroz.riceservice.modules.notifications.application.port.in.SendSMSToPendScheduleUseCase;
import org.sistema.arroz.riceservice.modules.notifications.application.port.out.SendSMSPort;
import org.sistema.arroz.riceservice.modules.schedule.domain.Schedule;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleDetail;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class SendSMStoPendScheduleService implements SendSMSToPendScheduleUseCase {
    private final SendSMSPort sendSMSPort;

    @Override
    public void sendSMSToPend(Schedule schedule, List<ScheduleDetail> scheduleDetails) {
        var pendingDate = schedule.getStartDate().toString();
        var productName = schedule.getProduct().getProductName();
        for (var scheduleDetail: scheduleDetails){
            var name = scheduleDetail.getProducer().getProducerName();
            var hectares = scheduleDetail.getHectares();
            var lastName = scheduleDetail.getProducer().getProducerFirstLastName();
            sendSMSPort.sendSMS(scheduleDetail.getProducer().getPhone(),
                    String.format(Messages.SMS_TO_PEND, name, lastName, pendingDate, hectares, productName));
        }
    }
}
