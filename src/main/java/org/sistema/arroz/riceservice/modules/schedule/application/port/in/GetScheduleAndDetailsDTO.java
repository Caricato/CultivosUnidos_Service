package org.sistema.arroz.riceservice.modules.schedule.application.port.in;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetScheduleAndDetailsDTO {
    GetScheduleDTO getScheduleDTO;
    List<GetScheduleDetailDTO> getScheduleDetailDTO;
}
