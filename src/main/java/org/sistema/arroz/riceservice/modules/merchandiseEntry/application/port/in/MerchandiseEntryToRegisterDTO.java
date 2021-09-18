package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseFlowType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseEntryToRegisterDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate entryDate;
    MerchandiseFlowType entryType;

    Long producerId;
    List<MerchandiseEntryDetailToRegister> detailsToRegister;
}
