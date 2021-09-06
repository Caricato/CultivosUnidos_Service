package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseEntryToRegisterDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate entryDate;
    MerchandiseEntryType entryType;

    @Nullable
    Long producerId;
    List<MerchandiseEntryDetailToRegister> detailsToRegister;
}
