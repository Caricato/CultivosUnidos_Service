package org.sistema.arroz.riceservice.modules.merchandiseEntry.application.port.in;

import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sistema.arroz.riceservice.modules.merchandiseEntry.domain.MerchandiseEntryType;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchandiseEntryToRegister {
    LocalDateTime entryDate;
    MerchandiseEntryType entryType;

    @Nullable
    Long producerId;
}
