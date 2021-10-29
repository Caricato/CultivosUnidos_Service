package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.producers.domain.Producer;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDetail {
    Long scheduleDetailId;
    Double hectares;
    Boolean isFreeHectares;
    Producer producer;
    Schedule schedule;
}
