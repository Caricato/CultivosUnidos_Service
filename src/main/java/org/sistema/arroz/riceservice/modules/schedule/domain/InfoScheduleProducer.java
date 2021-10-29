package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoScheduleProducer {
    Long producerId;
    Double totalHectares;
    Double takenHectares;
    Integer priority;
    Long communityId;
}
