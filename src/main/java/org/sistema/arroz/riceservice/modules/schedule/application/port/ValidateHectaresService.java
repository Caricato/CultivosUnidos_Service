package org.sistema.arroz.riceservice.modules.schedule.application.port;

import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.hexagonal.UseCase;
import org.sistema.arroz.riceservice.modules.producers.application.port.in.GetProducersUseCase;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ScheduleToRegister;
import org.sistema.arroz.riceservice.modules.schedule.application.port.in.ValidateHectaresUseCase;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.CountTakenHectaresPort;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.ProducersToValidate;
import org.sistema.arroz.riceservice.modules.schedule.application.port.out.ScheduleDetailToRegister;
import org.sistema.arroz.riceservice.modules.schedule.domain.ScheduleHectaresException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ValidateHectaresService implements ValidateHectaresUseCase {
    private final GetProducersUseCase getProducersUseCase;
    private final CountTakenHectaresPort countTakenHectaresPort;

    @Override
    public List<ScheduleDetailToRegister> validateHectares(Long communityId, ScheduleToRegister scheduleToRegister) {
        var producers = getProducersUseCase.getProducersForSchedule(communityId);
        var producersValidated = getProducersValidated(producers);
        return getProducersForSchedule(producersValidated, scheduleToRegister);
    }

    private List<ScheduleDetailToRegister> getProducersForSchedule(List<ProducersToValidate> producers, ScheduleToRegister scheduleToRegister){
        var auxHectares = 0.0;
        var counter = (scheduleToRegister.getCantProducers() != null) ? scheduleToRegister.getCantProducers(): producers.size();
        var i = 0;
        var scheduleDetails = new ArrayList<ScheduleDetailToRegister>();
        while(i < counter){
            if (auxHectares == scheduleToRegister.getHectares()) break;
            var hectaresForProducer = producers.get(i).getFreeHectares();
            if (auxHectares+hectaresForProducer > scheduleToRegister.getHectares()) hectaresForProducer = (scheduleToRegister.getHectares()-auxHectares);
            auxHectares+=hectaresForProducer;
            scheduleDetails.add(ScheduleDetailToRegister.builder().hectares(hectaresForProducer).isFreeHectares(false)
                    .producer(producers.get(i).getProducer())
                    .build());
            i++;
        }
        if (auxHectares < scheduleToRegister.getHectares()) throw new ScheduleHectaresException(scheduleToRegister.getHectares(), auxHectares);
        return scheduleDetails;
    }

    private List<ProducersToValidate> getProducersValidated(List<Producer> producers){
        var producersToValidate = new ArrayList<ProducersToValidate>(producers.size());
        for (Producer producer: producers){
            var takenHectares = countTakenHectaresPort.takenHectares(producer.getProducerId());
            var priority = 0;
            if (takenHectares != 0) priority = 1;
            producersToValidate.add(ProducersToValidate.builder().freeHectares(producer.getHectares()-takenHectares)
                            .priority(priority).producer(producer)
                            .build());
        }
        producersToValidate.sort((Comparator.comparing(ProducersToValidate::getFreeHectares)));
        producersToValidate.sort(Comparator.comparing(ProducersToValidate::getPriority));
        return producersToValidate;
    }
}
