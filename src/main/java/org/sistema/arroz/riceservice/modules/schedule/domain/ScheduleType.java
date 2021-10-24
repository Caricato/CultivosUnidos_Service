package org.sistema.arroz.riceservice.modules.schedule.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ScheduleType {
    PENDING(0), IN_PROCESS(1), FINALIZED(2), CANCELLED(3);

    @Getter
    private final Integer value;
}
